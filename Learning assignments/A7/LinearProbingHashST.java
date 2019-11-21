import java.util.Random;
import java.util.Collections;
public class LinearProbingHashST {

    int[] keys = new int[1000000];
    int size = 0;
    public int  m = 1000000;
    private int hash(int key) {
        return (Integer.valueOf(key).hashCode() & 0x7fffffff) % m;
    }

    public void put(int key) {

        int i;
        for (i = hash(key); keys[i] != 0; i = (i + 1) % m) {
            if (keys[i] == key) {
                return;
            }
        }
        keys[i] = key;
        size++;
    }
    public static void main(String[] args) {
        LinearProbingHashST lp = new LinearProbingHashST();
        Random rand = new Random();
        // int[] temp = new int[500000];
        for(int i = 0; i < 500000; i++) {
            int index = rand.nextInt(1000000);
            // System.out.println(index);
            lp.put(index);
        }
        System.out.println(lp.keys.length);
        System.out.println(lp.size);

        int c = 0;
        for (int i = 0; i < lp.m; i = i + 99) {
            if (lp.keys[i]/100 == 0) {
                c += 1;
            }
        }

        System.out.println(c/10000.00);
    }
}