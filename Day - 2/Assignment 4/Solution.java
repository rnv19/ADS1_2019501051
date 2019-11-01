import java.util.*;
final class Solution {
	/**
	 * In this method we are using queue and related methods
	 *  like add and remove.
	 * @param a input which implies number of numbers.
	 * @param b input which implies nth of number.
	 * @return returns string.
	 */
	public static String Josephus(final int a, final int b) {
		// fill you code Here
		Queue<Integer> q = new LinkedList<>();
		String s = "";
		for (int i = 0; i < a; i++) {
			q.add(i);
		}
		while (q.size() > 1) {
			for (int j = 0; j < b - 1; j++) {
				int temp = q.remove();
				q.add(temp);
			}
			s = s + q.remove() + " ";
		}
		s = s + q.remove();
		return s;
    }
}
