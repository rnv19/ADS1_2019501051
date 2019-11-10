import java.util.Arrays;
class BST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private int[] lLinks;
    private int[] rLinks;
    private Value[] vals;
    private int[] s;
    private final int sLimit = 500;
    private int n = 0;

    BST() {
        keys = (Key[])new Comparable[sLimit];
        lLinks = new int[sLimit];
        rLinks = new int[sLimit];
        vals = (Value[])new Object[sLimit];
        s = new int[sLimit];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public int size(int i) {
        return s[i];
    }

    public Value get(Key key) {
        return get(1, key);
    }

    private Value get(int index, Key key) {
        if (keys[index] == null) {
            return null;
        }
        int cmp = key.compareTo(keys[index]);
        
        if (cmp < 0) {
            return get(2 * index, key);
        } else if (cmp > 0) {
            return get((2 * index) + 1, key);
        } else {
            return vals[index];
        }
    }

    public void resize() {
        keys = Arrays.copyOf(keys, 2 * keys.length);
        vals = Arrays.copyOf(vals, 2 * vals.length);
        lLinks = Arrays.copyOf(lLinks, 2 * lLinks.length);
        rLinks = Arrays.copyOf(rLinks, 2 * rLinks.length);
        s = Arrays.copyOf(s, 2 * s.length);
    }

    public void put(Key key, Value value) {
		if (size() == keys.length) {
            resize();
			System.out.println("Size Limit Reached.");
			return;
		}
		put(1, key, value);
    }

	private void put(int index, Key key, Value value) {
        if (index > keys.length - 1) {
            resize();
            keys[index] = key;
            vals[index] = value;
            s[index] = 1;
            return;
        }
		if (keys[index] == null) {
			keys[index] = key;
			vals[index] = value;
            return;
		}    

		int compare = key.compareTo(keys[index]);

		if (compare < 0) {
            lLinks[index] = 2 * index;
            put(2 * index, key, value);
		} else if (compare > 0) {
            rLinks[index] = (2 * index) + 1;
            put((2 * index) + 1, key, value);
		} else {
			vals[index] = value;
        }
        s[index] = s[2 * index] + 1 + s[(2 * index) + 1];
        return;
	}
    
}