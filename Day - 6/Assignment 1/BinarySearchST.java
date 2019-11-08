/**
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Value[] vals;
    private Key[] keys;
    private int n = 0;

    public BinarySearchST(final int cap) {
        vals = (Value[]) new Object[cap];
        keys = (Key[]) new Comparable[cap];
    }

    public boolean contains(final Key key) {
        int i = rank(key);
        return keys[i].compareTo(key) == 0;
    }

    public Key max() {
        return keys[n - 1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void deleteMin() {
        if (!isEmpty()) {
            for (int i = 0; i < n - 1; i++) {
                keys[i] = keys[i + 1];
                vals[i] = vals[i + 1];
            }
            n -= 1;
        }
    }

    public Key floor(final Key key) {
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            return keys[i];
        } else {
            return keys[i - 1];
        }
    }

    public void resize() {
        if (n == vals.length) {
            Value[] tempv = (Value[]) new Object[n * 2];
            Key[] tempk = (Key[]) new Comparable[n * 2];
            for (int i = 0; i < n; i++) {
                tempk[i] = keys[i];
                tempv[i] = vals[i];
            }
            vals = tempv;
            keys = tempk;
        }
    }

    public void delete(final Key key) {
        int i = rank(key);
        for (int j = i; j < n; j--) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }
        n -= 1;
    }

    public void put(final Key k, final Value v) {
        if (v == null) {
            delete(k);
            return;
        }
        if (isEmpty()) {
            keys[n] = k;
            vals[n] = v;
            n++;
        }
        int i = rank(k);
        if (i < n && keys[i].compareTo(k) == 0) {
            vals[i] = v;
            return;
        }
        if (n == vals.length) {
            resize();
        }
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = k;
        vals[i] = v;
        n += 1;
    }
    public int rank(final Key key) {
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int temp = key.compareTo(keys[mid]);
            // System.out.println(temp);
            if (temp < 0) {
                hi = mid - 1;
            } else if (temp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public Value get(final Key key) {
        int i = rank(key);
        if (key.compareTo(keys[i]) == 0) {
            return vals[i];
        }
        return null;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += keys[i] + " ";
        }
        return str;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(final Key lo, final Key hi) {

        Queue<Key> queue = new Queue<Key>(); 
        if (lo.compareTo(hi) > 0) return queue;
        for (int i = rank(lo); i < rank(hi); i++) 
            queue.enqueue(keys[i]);
        if (contains(hi)) queue.enqueue(keys[rank(hi)]);
        return queue; 
    }
}
