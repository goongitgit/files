package priorityqueues;

import maps.AbstractIterableMap;
import maps.ChainedHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @see ExtrinsicMinPQ
 */
public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T> {
    // IMPORTANT: Do not rename these fields or change their visibility.
    // We access these during grading to test your code.
    static final int START_INDEX = 0;
    List<PriorityNode<T>> items;
    int size;
    AbstractIterableMap<T, Integer> valueLocations = new ChainedHashMap<>(2.0, 500, 10);
    public ArrayHeapMinPQ() {
        items = new ArrayList<>();
        size = 0;
    }

    // Here's a method stub that may be useful. Feel free to change or remove it, if you wish.
    // You'll probably want to add more helper methods like this one to make your code easier to read.
    /**
     * A helper method for swapping the items at two indices of the array heap.
     */

    @Override
    public void add(T item, double priority) {
        if (!contains(item)) {
            PriorityNode<T> newNode = new PriorityNode<>(item, priority);
            items.add(size, newNode);
            int index = percolateUp(size);
            valueLocations.put(item, index);
            size++;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int percolateUp(int index) {
        PriorityNode<T> nodeToPercolate = items.get(index);
        double nodeToPercolatePriority = nodeToPercolate.getPriority();
        PriorityNode<T> nodeSwitchedWith;
        int i = index;
        while (items.get((i-1)/2).getPriority() > nodeToPercolatePriority) {
            nodeSwitchedWith = items.get((i-1)/2);
            items.set((i-1)/2, nodeToPercolate);
            valueLocations.put(nodeToPercolate.getItem(), (i-1)/2);
            items.set(i, nodeSwitchedWith);
            valueLocations.put(nodeSwitchedWith.getItem(), i);
            i = (i-1)/2;
        }
        return i;
    }

    @Override
    public boolean contains(T item) {
        //check if hashmap contains the key "item", returns true/false
        return valueLocations.containsKey(item);
    }

    @Override
    public T peekMin() {
        if (size > 0) {
            return items.get(0).getItem();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public T removeMin() {
        T valueToReturn;
        if (size > 0) {
            if (size == 1) {
                valueToReturn = items.get(0).getItem();
                valueLocations.remove(items.get(0).getItem());
                items.remove(0);
                size--;
            } else {
                //save the last node in the heap/array
                PriorityNode<T> node = items.get(size-1);

                //save the value of the min value
                valueToReturn = items.get(0).getItem();
                valueLocations.remove(valueToReturn);

                //remove the last node in the array
                items.remove(size-1);

                //replace the min node (at index 0) with the last node we saved earlier as "node"
                items.set(0, node);

                //now that we have removed the min value and replaced it with the last value, we decrement size as
                //the total number of nodes is now one less
                size--;

                //After percolating, the index that the node has been switched to is saved
                percolateDown(0);

                //save the index of the percolated node by getting the nodes value (key) and adding it to the hashmap
                //with the value being the index returned by percolate. Since we can only have unique values for each
                //node in our heap, we can safely use them as keys to add or update their index positions.
                //valueLocations.put(node.getItem(), index);
            }
            //after saving the initial min node's value, return the value
            return valueToReturn;
        } else {
            throw new NoSuchElementException();
        }
    }

    public void percolateDown(int index) {
        //look at both left and right child and return the minimum index between the left and right child
        PriorityNode<T> nodeToPercolate = items.get(index);
        PriorityNode<T> nodeSwitchedWith;
        int i = index;
        int childI = findLeastPriority(i);

        //while the priority of my current index is greater than the priority of my child index
        while (childI < size && childI != -1 && items.get(i).getPriority() > items.get(childI).getPriority()) {
            //swap current and min child index
            nodeSwitchedWith = items.get(childI);
            items.set(i, nodeSwitchedWith);
            valueLocations.put(nodeSwitchedWith.getItem(), i);
            items.set(childI, nodeToPercolate);
            //update index to be child index
            i = childI;
            childI = findLeastPriority(i);
        }
        valueLocations.put(nodeToPercolate.getItem(), i);
    }

    public int findLeastPriority(int index) {
        int childIndex = -1;
        double leftChildPriority = -1;
        double rightChildPriority = -1;
        //check if left and right child exist, if so, save each child's priority
        if ((2 * index) + 1 < size) {
            leftChildPriority = items.get((2 * index) + 1).getPriority();
        }
        if ((2 * index) + 2  < size) {
            rightChildPriority = items.get((2 * index) + 2).getPriority();
        }
        if (leftChildPriority == -1 && rightChildPriority == -1) {
            return childIndex;
        }
        //get min priority
        if (leftChildPriority != -1 && rightChildPriority == -1) {
            return (2 * index) + 1;
        }
        double lowest = Math.min(leftChildPriority, rightChildPriority);
        if (lowest == rightChildPriority && rightChildPriority != -1) {
            childIndex = (2 * index) + 2;
        } else if (lowest == leftChildPriority || leftChildPriority == rightChildPriority) {
            childIndex = (2 * index) + 1;
        }
        return childIndex;
    }


    @Override
    public void changePriority(T item, double priority) {
        if (contains(item)) {
            int index = valueLocations.get(item);
            PriorityNode<T> node = items.get(index);
            node.setPriority(priority);
            items.set(index, node);
            percolateUp(index);
            percolateDown(index);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public int size() {
        return size;
    }
}
