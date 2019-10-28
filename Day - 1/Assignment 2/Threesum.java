import java.util.Arrays;

public class Threesum{
    public int sumCount(int[] a){
        Arrays.sort(a);
        int c = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                if(Arrays.binarySearch(a, -(a[i] + a[j])) < a.length){
                    // c += 1;
                    System.out.println(a[i]);
                }
            }            
        }return c;
        }
    public static void main(String args[]){
        Threesum ts = new Threesum();
        int[] arr = {30, -40, -20, -10, 40, 0, 10, 5};
        System.out.println(ts.sumCount(arr));
    }
}