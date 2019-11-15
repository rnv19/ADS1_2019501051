import java.util.NoSuchElementException;

public class CircularQueue<Item> {
    // private Node first;
    private Node last;
    private Item item;
    private int size;

    private class Node{
        Item item;
        Node next;
    }

    private CircularQueue () {
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Item item) {
        if(item == null) throw new IllegalArgumentException("Cannot add null item");
        Node newNode = new Node();
        newNode.item = item;
        if(size == 0) {
            last = newNode;
            last.next = last;
            size++;
        } else {
            Node temp = newNode;
            temp.next = last.next;
            last.next = temp;
            last = temp;
            size++;
        }
    }

    public Item dequeue() {
        if(size == 0) throw new NoSuchElementException("Empty queue");
        if(size == 1) {
            Item temp = last.item;
            last = null;
            size--;
            return temp;
        } else {
            Item temp = last.next.item;
            last.next = last.next.next;
            size--;
            return temp;
        }
    }
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();
        q.enqueue("it");
        q.enqueue("was");
        q.enqueue("the");
        q.enqueue("best");
        q.enqueue("of");
        q.enqueue("times");
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.size);
    }

}