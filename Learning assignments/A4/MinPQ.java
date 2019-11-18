import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class MinPQ {
    private int[] pq;                    // store items at indices 1 to n
    private int size;                       // number of items on priority queue

    public MinPQ(int initCapacity) {
        pq = new int[initCapacity + 1];
        size = 0;
    }

    public MinPQ() {
        this(1);
    }

    public MinPQ(int[] keys) {
        size = keys.length;
        pq = new int[keys.length + 1];
        for (int i = 0; i < size; i++)
            pq[i+1] = keys[i];
        for (int k = size/2; k >= 1; k--)
            sink(k);
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public int min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    private void resize(int capacity) {
        assert capacity > size;
        int[] temp = new int[capacity];
        for (int i = 1; i <= size; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    // time complexity is n logn
    public void insert(int x) {
        if (size == pq.length - 1) resize(2 * pq.length);
        pq[++size] = x;
        swim(size);
    }

    // time complexity is (n-k) logn
    public int delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, size--);
        sink(1);
        pq[size+1] = 0;
        if ((size > 0) && (size == (pq.length - 1) / 4)) resize(pq.length / 2);
        return min;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }


    private boolean greater(int i, int j) {
        return pq[i] > pq[j];
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    public String toString() {
        String s = "";
        for(int i = 1; i < size + 1; i++) {
            if(i == 1) {s = s + pq[i]; }
            else {s = s + "-" + pq[i]; }
        }return s;
    }

    public static void main(String[] args) {
        MinPQ pq = new MinPQ();
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int i = n;
        System.out.println("Enter k");
        int k = sc.nextInt();
        while(n != 0) {
            int e = r.nextInt(500);
            pq.insert(e);
            n--;
        }
        // System.out.println(pq);
        int delSize = 0;
        int j = i - k;
        int[] delEle = new int[j];
        while(j > 0)  {
            delEle[delSize++] = pq.delMin();
            j--;
        }
        System.out.println(pq);
    }
}
