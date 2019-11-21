import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private int size;
    private Item[] arr;

    // construct an empty randomized queue
    public RandomizedQueue() {
        arr = (Item[]) new Object[2];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int cap) {
        Item[] temp = (Item[]) new Object[cap];
        for (int i = 0; i < size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }
 
    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Cannot add null item");
        if (size == arr.length) resize(2 * arr.length);
        arr[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) throw new NoSuchElementException("empty queue");
        int n = StdRandom.uniform(size);
        Item temp = arr[n];
        // for(int i = n; i < size; i++) {
        //     arr[i] = arr[i+1];
        // }
        arr[n] = arr[size-1];
        arr[size-1] = null;
        size--;
        return temp;
   }

    // return a random item (but do not remove it)
    public Item sample() {
        int n = StdRandom.uniform(size);
        return arr[n];
    }

    // return an independent iterator over items in random order
    // public Iterator<Item> iterator(){}
    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Item current;
        private int size;
        
        /** Returns true if there is an item next in the deque */
    public void itemIterator() {
            size = 0;
            StdRandom.shuffle(arr, 0, size);
            current = arr[size];
        }
    @Override
    public boolean hasNext() {
            return (current != null);
        }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
        /** returns the current item and increments the pointer */
    @Override
    public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more objects to iterate through");
            }
            
            Item item = arr[size];
            size++;
            current = arr[size];
            return item;
        }
    }
    public static void main(String[] args) {
        RandomizedQueue rq = new RandomizedQueue();
        System.out.println(rq.size);
        rq.enqueue("it");
        rq.enqueue("was");
        rq.enqueue("the");
        rq.enqueue("best");
        rq.enqueue("of");
        rq.enqueue("times");
        // System.out.println(rq.dequeue());
        // System.out.println(rq.dequeue());
        // System.out.println(rq.dequeue());
        // System.out.println(rq.size);
        System.out.println(rq.sample());

    }
}