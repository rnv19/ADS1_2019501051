import java.util.Arrays;
class Solution{
    public int[] sortInsertion(int[] arr){
		// fill you code Here
		int n = arr.length;
		if(n != 1){
			for(int i = 1; i < n; i++){
				for(int j = i; j > 0; j--){
					if(arr[j] < arr[j-1]){
						swap(arr, j, j-1);
					}
				}
			}
		}return arr;
        
    }


    public int[] sortSelection(int[] arr){
        // fill you code Here
        int n= arr.length;
        if(n != 1){
            for(int i = 0; i < n; i++){
                int key = i;
                for(int j = i + 1; j < n; j++){
                    if(arr[j] < arr[key]){
                        swap(arr, j, key);
                    }
                }
            }
        }return arr;
    }

	public int[] swap(int[] arr, int a, int b){
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
		return arr;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = {787, 879, 180, 316, 904, 612, 778, 936, 422, 859};
		System.out.println(Arrays.toString(s.sortSelection(arr)));
	}
} 