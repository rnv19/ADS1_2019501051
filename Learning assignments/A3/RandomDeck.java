import java.util.Arrays;
import java.util.Scanner;

public class RandomDeck {

    public Card[] insertionSort(Card[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j].compareTo(arr[j-1]) < 0) {
                    arr = swap(arr, j, j-1);
                }
            }
        }return arr;
    }

    public Card[] swap(Card[] arr, int a, int b){
		Card temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
		return arr;
    }
    

    public static void main(String[] args) {
        RandomDeck rd = new RandomDeck();
        int size = 0;
        Card[] cards = new Card[10];
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        String sut = "";
        String val = "";
        for(int i = 0; i < ss.length; i++) {
            if(ss[i].length() == 3) {
                sut = String.valueOf(ss[i].charAt(0));
                val = ss[i].substring(1,3);
            }else if(ss[i].length() == 2) {
                sut = String.valueOf(ss[i].charAt(0));
                val = String.valueOf(ss[i].charAt(1));
            }
            Card c = new Card(sut, val);
            cards[size++] = c;
        }
        rd.insertionSort(cards);
        System.out.println(Arrays.toString(cards));
    }

    
}