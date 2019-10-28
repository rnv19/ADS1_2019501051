import java.util.Arrays;
public class Numpairs{

    public int pairs(int[] a){
        Arrays.sort(a);
        int c = 0;
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] == a[i+1]){
                c +=1;
            }
        }return c;
    }
    public static void main(String args[]){
        Numpairs np = new Numpairs();
        int[] arr = {1,1,2,3,4};
        System.out.println(np.pairs(arr));
    }
}