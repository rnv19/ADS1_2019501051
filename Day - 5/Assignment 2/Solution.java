import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Arrays;

final class Solution {
/* default constructor */
    private Solution() {
	}
    public static double[] dynamicMedian(final double[] arr) {
        PriorityQueue<Double> minQ = new PriorityQueue<Double>();
        PriorityQueue<Double> maxQ = new PriorityQueue<Double>(
                                        Collections.reverseOrder());
        double[] resultArray = new double[arr.length];
        double median = arr[0];
        // minQ.add(median);
        // resultArray[0] = median;

        for (int i = 0; i < arr.length; i++) {
            if (minQ.size() > maxQ.size()) {
                if (arr[i] > median) {
                    maxQ.add(minQ.remove());
                    minQ.add(arr[i]);
                } else {
                    maxQ.add(arr[i]);
                }
                median = (minQ.peek() + maxQ.peek()) / 2.0;
            } else if (minQ.size() < maxQ.size()) {
                if (arr[i] < median) {
                    minQ.add(maxQ.remove());
                    maxQ.add(arr[i]);
                } else {
                    minQ.add(arr[i]);
                }
                median = (minQ.peek() + maxQ.peek()) / 2.0;
            } else {
                if (arr[i] < median) {
                    maxQ.add(arr[i]);
                    median = maxQ.peek();
                } else {
                    minQ.add(arr[i]);
                    median = minQ.peek();
                }
            }
            resultArray[i] = median;
        }
        return resultArray;
    }

	public static void main(String[] args) {
		double[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(Arrays.toString(dynamicMedian(arr)));
}
}
