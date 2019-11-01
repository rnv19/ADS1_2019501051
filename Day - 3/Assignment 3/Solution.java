import java.util.Arrays;
class Solution{
	public int[] sortInsertion(int[] arr){
		// fill you code Here
		int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        }return arr;
	}


	public int[] sortSelection(int[] arr){
		// fill you code Here
		int N = arr.length;
		for(int i = 0; i < N; i++){
			int mid = i;
			for(int j = i + 1; j < N - 1; j++){
				if(arr[j] < arr[j+1]){ 
					mid = j;
				}mid = j+1;
			}if(arr[mid] < arr[i]){
				swap(arr[i], arr[mid]);
			}
		}return arr;
	}

	public void swap(int a, int b){
		int temp = a;
		b = a;
		a = temp;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = {46, 82, 648, 786, 795, 516, 24, 364, 364, 752, 898, 809, 201, 615, 809, 884, 257, 22};
		System.out.println(Arrays.toString(s.sortSelection(arr)));
	}
} 