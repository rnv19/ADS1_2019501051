
public class SequentialSearchST<Key, Value> {
    private int n;
    private Node first;

    private final class Node {
        private Key key;
        private Value val;
        private Node next;

        private Node(final Key key, final  Value val, final  Node next)  {
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

    public Value get(final  Key key) {
        Value value = null;
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                delete(key);
                value = x.val;
            }
            if (x.next == null) {
                Node n = new Node(key, value, null);
                x.next = n;
                return value;
            }
        }
        return null;
    }

    public void delete(final Key key) {
        first = delete(first, key);
    }

    public Node delete(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public boolean contains(final Key key) {
        return get(key) != null;
    }

    public void put(final Key key, final Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    public Iterable<Key> keys()  {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }
}
