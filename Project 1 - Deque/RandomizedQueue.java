import java.util.Random;;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node{
        Item item;
        Node next;
        Node previous;
    }

    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        first = null;
        last = null;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if(item == null) throw new IllegalArgumentException("Cannot add null item");
            Node newNode = new Node();
            newNode.item = item;
            if(size == 0) {
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

    // remove and return a random item
    public Item dequeue() {
        Random rand = new Random();
        int n = rand.nextInt(size);
        
        

    }

    // return a random item (but do not remove it)
    public Item sample()

    // return an independent iterator over items in random order
    public Iterator<Item> iterator()

    // unit testing (required)
    public static void main(String[] args)

}