import java.util.Scanner;
import java.util.Arrays;

public class Farthest {
    //constructor
    public Farthest() {}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of integers");
        int noOfElements = sc.nextInt();
        System.out.println("Enter the array integers");
        Double[] db = new Double[noOfElements];
        while (true) {
            for (int i = 0; i < noOfElements; i++) {
                db[i] = sc.nextDouble();
            }
            break;
        }

        double max = db[0];
        double min = db[0];
        for(int i = 1; i < noOfElements; i++) {
            if (db[i] > max) {
                max = db[i];
            }else min = db[i];
        }
        System.out.println(Arrays.toString(db));
        System.out.println(max - min);
    }
}
