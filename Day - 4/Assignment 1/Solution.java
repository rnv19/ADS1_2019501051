/**
 * . solution class
 */
import java.util.Random;
class Solution {
	/**
	 * . quicksort method method takes the array and sorts the array
	 *
	 * @param arr array to be sorted
	 * @return the array thats sorted
	 */
	public static int[] quickSort(final Comparable[] arr) {
	Random rand = new Random();
	QuickSort q = new QuickSort();
	for(int i = 0; i < arr.length; i++){
		int randomIndexToSwap = rand.nextInt(arr.length);
		int temp = arr[randomIndexToSwap];
		arr[randomIndexToSwap] = arr[i];
		arr[i] = temp;
	}
	q.sort(arr, 0, arr.length-1);
	return arr;
	}
}
