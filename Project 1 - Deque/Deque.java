// import java.util.ListIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }
        // construct an empty deque
        public Deque() {
            size = 0;
            first = null;
            last = null;
        }   

        // is the deque empty?
        public boolean isEmpty() {
            return size == 0;
        }
    
        // return the number of items on the deque
        public int size() {
            return size;
        }
    
        // add the item to the front
        public void addFirst(Item item) {
            if (item == null) throw new IllegalArgumentException("Cannot add null item");
            Node newNode = new Node();
            newNode.item = item;
            if (size == 0) {
                first = newNode;
                last = newNode;
                newNode.next = null;
                newNode.previous = null;
                size++;
            } else {
                Node temp = first;
                first = newNode;
                first.next = temp;
                first.previous = null;
                temp.previous = first;
                size++;
            }
        }
    
        // add the item to the back
        public void addLast(Item item) {
            if (item == null) throw new IllegalArgumentException("Cannot add null item");
            
            Node newNode = new Node();
            newNode.item = item;
            if (size == 0) {
                first = newNode;
                last = newNode;
                size++;
            }
            else {
                Node temp = last;
                last = newNode;
                last.next = null;
                last.previous = temp;
                temp.next = last;
                size++;
            }
        }
    
        // remove and return the item from the front
        public Item removeFirst() {
            if (size == 0) throw new NoSuchElementException("Deque is empty");
            Item temp = null;
            if (size == 1) {
                temp = first.item;
                first = null;
                last = null;
            } else {
                temp = first.item;
                first = first.next; 
                first.previous = null;
            }
            size--;
            return temp;
            

        }
    
        // remove and return the item from the back
        public Item removeLast() {

            if (size == 0) throw new NoSuchElementException("Deque is empty");
            Item temp = null;
            if (size == 1) {
                temp = last.item;
                first = null;
                last = null;
            } else {
                temp = last.item;
                last = last.previous;
                last.next = null;
            }
            size--;
            return temp;
        } 
    
        // return an iterator over items in order from front to back
        public Iterator<Item> iterator() {
            return new ListIterator();
        }

        private class ListIterator implements Iterator<Item> {
            private Node current = first;
            
            /** Returns true if there is an item next in the deque */
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
                
                Item item = current.item;
                current = current.next;
                
                return item;
            }
        }
    
        // unit testing (required)
        public static void main(String[] args) {
            Deque d = new Deque();
            d.addFirst("it");
            d.addFirst("was");
            d.addFirst("best");
            d.addFirst("of");
            d.addFirst("times");
            d.addLast("hello");
            System.out.println(d.size);
            System.out.println(d.removeFirst());
            System.out.println(d.removeLast());
        }
    
}