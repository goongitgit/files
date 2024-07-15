package maps;

//import com.sun.jdi.Value;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @see AbstractIterableMap
 * @see Map
 */
public class ChainedHashMap<K, V> extends AbstractIterableMap<K, V> {
    private static final double DEFAULT_RESIZING_LOAD_FACTOR_THRESHOLD = 0.75;
    private static final int DEFAULT_INITIAL_CHAIN_COUNT = 10;
    private static final int DEFAULT_INITIAL_CHAIN_CAPACITY = 5;

    /*
    Warning:
    You may not rename this field or change its type.
    We will be inspecting it in our secret tests.
     */
    AbstractIterableMap<K, V>[] chains;
    double lambda;
    double numOfPairs;
    int chainCapacity;

    // You're encouraged to add extra fields (and helper methods) though!



    /**
     * Constructs a new ChainedHashMap with default resizing load factor threshold,
     * default initial chain count, and default initial chain capacity.
     */
    public ChainedHashMap() {
        this(DEFAULT_RESIZING_LOAD_FACTOR_THRESHOLD, DEFAULT_INITIAL_CHAIN_COUNT, DEFAULT_INITIAL_CHAIN_CAPACITY);
    }

    /**
     * Constructs a new ChainedHashMap with the given parameters.
     *
     * @param resizingLoadFactorThreshold the load factor threshold for resizing. When the load factor
     *                                    exceeds this value, the hash table resizes. Must be > 0.
     * @param initialChainCount the initial number of chains for your hash table. Must be > 0.
     * @param chainInitialCapacity the initial capacity of each ArrayMap chain created by the map.
     *                             Must be > 0.
     */
    public ChainedHashMap(double resizingLoadFactorThreshold, int initialChainCount, int chainInitialCapacity) {
        chains = createArrayOfChains(initialChainCount);
        lambda = resizingLoadFactorThreshold;
        chainCapacity = chainInitialCapacity;
    }

    /**
     * This method will return a new, empty array of the given size that can contain
     * {@code AbstractIterableMap<K, V>} objects.
     *
     * Note that each element in the array will initially be null.
     *
     * Note: You do not need to modify this method.
     * @see ArrayMap createArrayOfEntries method for more background on why we need this method
     */
    @SuppressWarnings("unchecked")
    private AbstractIterableMap<K, V>[] createArrayOfChains(int arraySize) {
        return (AbstractIterableMap<K, V>[]) new AbstractIterableMap[arraySize];
    }

    /**
     * Returns a new chain.
     *
     * This method will be overridden by the grader so that your ChainedHashMap implementation
     * is graded using our solution ArrayMaps.
     *
     * Note: You do not need to modify this method.
     */
    protected AbstractIterableMap<K, V> createChain(int initialSize) {
        return new ArrayMap<>(initialSize);
    }

    @Override
    public V get(Object key) {
        if (key != null) {
            int hashIndex = Math.abs(key.hashCode()) % chains.length;
            if (chains[hashIndex] != null) {
                AbstractIterableMap<K, V> arrayMap = chains[hashIndex];
                return arrayMap.get(key);
            }
        }

        if (key == null) {
            AbstractIterableMap<K, V> arrayMap = chains[0];
            return arrayMap.get(key);
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V valueToReturn = null;
        if ((numOfPairs / (double) chains.length) >= lambda) {
            resize();
            put(key, value);
        }
        int hashCodeIndex = 0;
        if (key != null) {
            hashCodeIndex = Math.abs(key.hashCode()) % chains.length;
        }
        if (chains[hashCodeIndex] != null) {
            AbstractIterableMap<K, V> chain = chains[hashCodeIndex];
            valueToReturn = chain.get(key);
            if (!chain.containsKey(key)) {
                numOfPairs += 1.0;
            }
            chain.put(key, value);
        } else {
            AbstractIterableMap<K, V> newChain = createChain(chainCapacity);
            newChain.put(key, value);
            chains[hashCodeIndex] = newChain;
            numOfPairs += 1.0;
        }
        return valueToReturn;
    }

    public void resize() {
        AbstractIterableMap<K, V>[] newChains = createArrayOfChains(chains.length * 2);
        V valueToReturn = null;
        for (int i = 0; i < chains.length; i++) {
            if (chains[i] != null) {
                AbstractIterableMap<K, V> arrayMap = chains[i];
                for (int j = 0; j < arrayMap.size(); j++) {
                    Iterator<Entry<K, V>> arrayMapIterator = arrayMap.iterator();
                    while (arrayMapIterator.hasNext()) {
                        Entry<K, V> entryToMove = arrayMapIterator.next();
                        int newHashCode = Math.abs(entryToMove.getKey().hashCode()) % newChains.length;
                        if (entryToMove.getKey() == null) {
                            newHashCode = 0;
                        }
                        if (newChains[newHashCode] == null) {
                            AbstractIterableMap<K, V> newChain = createChain(chainCapacity);
                            newChain.put(entryToMove.getKey(), entryToMove.getValue());
                            newChains[newHashCode] = newChain;
                        } else {
                            AbstractIterableMap<K, V> chain = newChains[newHashCode];
                            chain.put(entryToMove.getKey(), entryToMove.getValue());
                        }
                    }
                }
            }
        }
        chains = newChains;
    }

    @Override
    public V remove(Object key) {
        int hashCodeIndex = 0;
        if (key != null) {
            hashCodeIndex = Math.abs(key.hashCode()) % chains.length;
        }
        AbstractIterableMap<K, V> chain = chains[hashCodeIndex];
        if (chain != null && chain.containsKey(key)) {
            numOfPairs -= 1;
            V returnValue = chain.remove(key);
            if (chain.size() == 0) {
                chains[hashCodeIndex] = null;
            }
            return returnValue;
        }
        return null;
    }

    @Override
    public void clear() {
        chains = createArrayOfChains(DEFAULT_INITIAL_CHAIN_COUNT);
        numOfPairs = 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int hashCodeIndex = 0;
        if (key != null) {
            hashCodeIndex = Math.abs(key.hashCode()) % chains.length;
        }
        AbstractIterableMap<K, V> chain = chains[hashCodeIndex];
        if (chain != null && chain.containsKey(key)) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return (int) numOfPairs;
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        // Note: you won't need to change this method (unless you add more constructor parameters)
        return new ChainedHashMapIterator<>(this.chains, size());
    }

    /*
    See the assignment webpage for tips and restrictions on implementing this iterator.
     */
    private static class ChainedHashMapIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        private AbstractIterableMap<K, V>[] chains;
        int currentChain = 0;

        AbstractIterableMap<K, V> chain;
        Iterator<Entry<K, V>> chainIterator;
        int iteratorIndex;
        int size;
        int numReturned;
        public ChainedHashMapIterator(AbstractIterableMap<K, V>[] chains, int size) {
            this.chains = chains;
            this.size = size;
        }

        @Override
        public boolean hasNext() {
            if (chains == null || size == 0 || numReturned >= size) {
                return false;
            }
            return true;
        }

        @Override
        public Map.Entry<K, V> next() {
            Entry<K, V> entryToReturn = null;
            if (hasNext()) {
                chain = chains[currentChain];
                while (chain == null && currentChain < chains.length - 2) {
                    currentChain++;
                    chain = chains[currentChain];
                }
                chainIterator = chain.iterator();
                if (chainIterator.hasNext()) {
                    //increment iterator index so that even if there is 1 element,
                    //iterator will run 1 time, otherwise, index isn't initialized.
                    //if there are 2 elements, on the second call, iterator will run
                    //twice. First setting return value to iterator[i], then, on the next run
                    //of the for loop, sets return value to iterator[i+1]. After for loop is done,
                    //check if iterator has next again (this will always indicate that we have reached the
                    // end of the chain, as the arrayMap hasnext checks if its iterator index is less
                    // than size)
                    iteratorIndex++;

                    for (int i = 0; i < iteratorIndex; i++) {
                        if (chainIterator.hasNext()) {
                            entryToReturn = chainIterator.next();
                        }
                    }
                    numReturned++;
                    if (!chainIterator.hasNext()) {
                        currentChain++;
                    }
                }
            } else {
                throw new NoSuchElementException();
            }
            return entryToReturn;
        }
    }
}
