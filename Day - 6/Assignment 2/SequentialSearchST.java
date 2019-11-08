import java.util.*;
public class SequentialSearchST<Key, Value> {
    private int n;
    private Node first;
    
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Value get(Key key) {
        for(Node x = first; x != Null; x.next) {
            if(key.equals(x.key)){
                return x.val;
            }
        }return null;
    }

    public void delete(Key key) {
        for(Node x = first; x != Null; x.next) {
            if(key.equals(x.key)) {
                x.next = x.next.next;
                n--;
            }
        }
    }
 
    public boolean contains(Key key){
        for(Node x = first; x != Null; x.next) {
            if(key.equals(x.key)) {
                return true;
            }return false;
        }
    }

    public void put(Key key, Value val){
        if( val == null) {
            delete(key);
        }
        if(contains(key)) {
            
        }

        }
    }

    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }
}