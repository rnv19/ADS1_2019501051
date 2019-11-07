import java.util.Arrays;
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    
    private Value[] vals;
    private Key[] keys;
    private int n = 0;

    public BinarySearchST(int cap){
        Value[] vals = new Value[cap];
        Key[] keys = new Key[cap];
    }

    public boolean contains(Key key){
        int i = rank(key);
        return i >= 0;
    }

    public Value get(Key key) {
        if(contains(key)) {
            return vals[key];
        }
        return null;
    }

    public Key max() {
        return keys[n-1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void deleteMin() {
        if(!isEmpty()) {
            for(int i = 0; i < n - 1; i++) {
                keys[i] = keys[i+1];
                vals[i] = vals[i+1];
                n -= 1;
            }
        }
    }

    public Key floor(Key key) {
        int i = rank(key);
        if (i < n && key.toCompare(keys[i]) == 0){
            return keys[i];
        }else return keys[i - 1];
    }

    public void resize() {
        if(n == vals.length) {
            vals = Arrays.copyOf(vals, n*2);
            keys = Arrays.copyOf(keys, n*2);
        }
    }

    public void delete(Key key) {
        int i = rank(key);
        if(key.toCompare(keys[i]) == 0){
            for(int j = i; j < n; j--){
                keys[i] = keys[i+1];
                vals[i] = vals[i+1];
                n -= 1;
            }
        } 
        keys[n] = null;
        vals[n] = null;
    }

    public void put(Key k, Value v){
        if(!isEmpty()) {
            if(v == null) {
                delete(k);
                return;
            }
        }
        int i = rank(k);

        if(i < n && k.toCompare(keys[i]) == 0) {
            vals[i] = v;
        } else if(n == vals.length){
            resize();
            for(int j = i; j < n; j++){
                keys[j+1] = keys[j];
                vals[j+1] = vals[j+1];
            }
            keys[i] = k;
            vals[i] = v;
            n += 1;
        }
    }
    
    
    public int rank(Key key) {
        int lo = 0;
        int hi = n-1;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            int temp = key.toCompare(keys[mid]);
            if(temp < 0) {
                hi = mid-1;
            } else if(temp > 0) {
                lo = mid + 1;
            } else return mid;
        }
        return lo;
    }

    // public Iterable<Key> keys() {
    //     return keys(min(), max());
    // }
}