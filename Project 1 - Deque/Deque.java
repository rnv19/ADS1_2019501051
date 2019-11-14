import java.util.ListIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public class Node{
        private Item item;
        private Node next;
        private Node previous;

        public Node(Item item) {
            this.item = item;
        }
    }
        // construct an empty deque
        public Deque() {}   

        // is the deque empty?
        public boolean isEmpty(){
            return size == 0;
        }
    
        // return the number of items on the deque
        public int size() {
            return size;
        }
    
        // add the item to the front
        public void addFirst(Item item) {
            if(item == null) throw new IllegalArgumentException("Cannot add null item");
            if(size == 1) {
                Node newNode = new Node(item);
                newNode.left = null;
                newNode.right = null;
                first = newNode;
                // last = newNode;
                size++;
            } else {
                Node temp = new Node(item);
                temp.right = first;
                temp.left = null;
                first = temp;
                size++;
            }
        }
    
        // add the item to the back
        public void addLast(Item item) {
            if(item == null) throw new IllegalArgumentException("Cannot add null item");

            if(last == null) {
                Node newNode = new Node(item);
                newNode.left = last;
                newNode.right = null;
                last = newNode;
                size++;
            } else {
                Node temp = new Node(item);
                temp.left = last;
                temp.right = null;
                last = temp;
                size++;
            }
        }
    
        // remove and return the item from the front
        public Item removeFirst() {

            if(size == 0) throw new NoSuchElementException("Deque is empty");
            Node temp = first;
            first = first.right;
            return temp.item;
        }
    
        // remove and return the item from the back
        public Item removeLast() {

            if(size == 0) throw new NoSuchElementException("Deque is empty");
            if(size == 1) {
                Item temp = last.item;
                first = null;
                last = null;
                size--;
                return temp;
            } else {
                Item tempItem = last.item;
                last = last.left;
                size -= 1;
                return tempItem;
            }

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
    
            /** returns the current item and increments the pointer */
            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more objects to iterate through");
                }
                
                Item item = current.item;
                current = current.right;
                
                return item;
            }
        }
    
        // unit testing (required)
        public static void main(String[] args) {
            Deque d = new Deque();
            // d.addFirst("it");
            // d.addFirst("was");
            // d.addFirst("best");
            // d.addFirst("of");
            d.addFirst("times");
            d.addLast("hello");
            System.out.println(d.size);
            // System.out.println(d.removeFirst());
            // System.out.println(d.removeFirst());
            // System.out.println(d.removeFirst());
            // System.out.println(d.removeFirst());
            // System.out.println(d.removeFirst());
            // System.out.println(d.removeFirst());
            System.out.println(d.removeLast());
            System.out.println(d.size);

            System.out.println(d.removeLast());
            // System.out.println(d.removeLast());
            // System.out.println(d.removeLast());
            // System.out.println(d.removeLast());
            System.out.println(d.size);
            // System.out.println(d.removeLast());
            // System.out.println(d.removeFirst());
            // System.out.println(d.removeLast());
        }
    
}