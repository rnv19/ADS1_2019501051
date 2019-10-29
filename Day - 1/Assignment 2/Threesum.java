import java.util.Arrays;

public class Threesum{
    public int sumCount(int[] a){
        Arrays.sort(a);
        int c = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                int d = -(a[i] + a[j]);
                if(a[i] < a[j] && a[j] < d){
                    if(Arrays.binarySearch(a, d) > 0 ){
                        c += 1;
                    }
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