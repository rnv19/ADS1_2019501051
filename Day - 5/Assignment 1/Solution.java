final class Solution {
	private Solution() { }
	public static boolean isMinHeap(final double[] arr) {
		int c = 0;
		int n = arr.length;
		if (n == 2) {
			if (arr[0] < arr[1]) {
				return true;
			}
			return false;
		} else if (n != 0) {
			if (n == 1) {
				return true;
			}
			for (int i = 0; i < (n - 2) / 2; i++) {
				if (arr[i] <= arr[2 * i + 1]) {
					if (arr[i] <= arr[2 * i + 2]) {
						c += 1;
					}
				}
			} if (c == (n - 2) / 2) {
				return true;
			}
			return false;
		}
		return false;
	}
}

