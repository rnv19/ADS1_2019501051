public class Sortsum{
    public int[] sum(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        int as = 0;
        int bs = 0;
        int cs = 0;
        while(cs != c.length){
            if(a[as] < b[bs]){
                c[cs++] = a[as++];
            }else c[cs++] = b[bs++];
        }return c;
    }
    public static void main(String args[]){
        Numpairs np = new Numpairs();
        int[] arr = {1,1,2,3,4};
        System.out.println(np.pairs(arr));
    }
}