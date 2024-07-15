package maps;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @see AbstractIterableMap
 * @see Map
 */
public class ArrayMap<K, V> extends AbstractIterableMap<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 15;
    /*
    Warning:
    You may not rename this field or change its type.
    We will be inspecting it in our secret tests.
     */
    SimpleEntry<K, V>[] entries;
    int size;

    // You may add extra fields or helper methods though!

    /**
     * Constructs a new ArrayMap with default initial capacity.
     */
    public ArrayMap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * Constructs a new ArrayMap with the given initial capacity (i.e., the initial
     * size of the internal array).
     *
     * @param initialCapacity the initial capacity of the ArrayMap. Must be > 0.
     */
    public ArrayMap(int initialCapacity) {
        this.entries = this.createArrayOfEntries(initialCapacity);
        size = 0;
    }

    /**
     * This method will return a new, empty array of the given size that can contain
     * {@code Entry<K, V>} objects.
     *
     * Note that each element in the array will initially be null.
     *
     * Note: You do not need to modify this method.
     */
    @SuppressWarnings("unchecked")
    private SimpleEntry<K, V>[] createArrayOfEntries(int arraySize) {
        /*
        It turns out that creating arrays of generic objects in Java is complicated due to something
        known as "type erasure."

        We've given you this helper method to help simplify this part of your assignment. Use this
        helper method as appropriate when implementing the rest of this class.

        You are not required to understand how this method works, what type erasure is, or how
        arrays and generics interact.
        */
        return (SimpleEntry<K, V>[]) (new SimpleEntry[arraySize]);
    }

    @Override
    public V get(Object key) {
        V returnValue = null;
        if (containsKey(key)) {
            for (int i = 0; i < size; i++) {
                if (entries[i].getKey() != null) {
                    if (entries[i].getKey().equals(key)) {
                        returnValue = entries[i].getValue();
                    }
                } else if (key == null && entries[i].getKey() == key) {
                    returnValue = entries[i].getValue();
                }
            }
        }
        return returnValue;
    }

    @Override
    public V put(K key, V value) {
        SimpleEntry<K, V> newEntry = new SimpleEntry<>(key, value);
        if (entries.length == size()) {
            SimpleEntry<K, V>[] newEntries = createArrayOfEntries(size()*2);
            for (int i = 0; i < entries.length; i++) {
                newEntries[i] = entries[i];
            }
            entries = newEntries;
        }
        if (!containsKey(key)) {
            size += 1;
            entries[size-1] = newEntry;
            return null;
        }
        V returnValue = null;
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey() != null) {
                if (entries[i].getKey() == key || entries[i].getKey().equals(key)) {
                    returnValue = get(key);
                    entries[i] = newEntry;
                }
            }
        }
        return returnValue;
    }

    @Override
    public V remove(Object key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey() == key || entries[i].getKey().equals(key)) {
                SimpleEntry<K, V> oldValue = entries[i];
                if (i != size - 1) {
                    entries[i] = entries[size() -1];
                } else {
                    entries[i] = null;
                }
                size -= 1;
                return oldValue.getValue();
            }
        }
        return null;
    }

    @Override
    public void clear() {
        entries = createArrayOfEntries(15);
        size = 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (entries[i] != null) {
                if (entries[i].getKey() == null) {
                    return true;
                } else {
                    if (entries[i].getKey().equals(key)) {
                        return true;
                    }
                }

            }

        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        // Note: You may or may not need to change this method, depending on whether you
        // add any parameters to the ArrayMapIterator constructor.
        return new ArrayMapIterator<>(this.entries, this.size);
    }

    // Doing so will give you a better string representation for assertion errors the debugger.
    @Override
    public String toString() {
        return super.toString();
    }

    private static class ArrayMapIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        private final SimpleEntry<K, V>[] entries;
        private final int size;
        int i = 0;

        public ArrayMapIterator(SimpleEntry<K, V>[] entries, int size) {
            this.entries = entries;
            this.size = size;
        }

        @Override
        public boolean hasNext() {
            if (i < size && entries[i] != null) {
                return true;
            }
            return false;
        }

        @Override
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            i++;
            return entries[i-1];
        }
    }
}
