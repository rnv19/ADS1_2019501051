import java.util.Arrays;
public class Sortsum{
    public int[] sum(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        int as = 0;
        int bs = 0;
        int cs = 0;
        while(cs != c.length){
            if(as == a.length){ c[cs++] = b[bs++];
            }else if(bs == b.length){ c[cs++] = a[as++];
            }else if(a[as] < b[bs]){ c[cs++] = a[as++];
            }else { c[cs++] = b[bs++];}
        }return c;
    }
    public static void main(String args[]){
        Sortsum ss = new Sortsum();
        int[] arr1 = {1,3,4,17,19};
        int[] arr2 = {3,10,15,20,25};
        int[] z = ss.sum(arr1, arr2);
        System.out.println(Arrays.toString(z));
    }
}