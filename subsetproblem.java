package externalDaa;

public class subsetproblem {
	public static void main(String[] args) {
		int arr[] = { 3, 34, 4, 12, 5, 2 };
		System.out.println(sub(arr, arr.length, 13));
	}

//	public static boolean subset(int arr[], int n, int sum) {
//
//		if (sum == 0) {
//			return true;
//		}
//		if (n == 0 && sum != 0) {
//			return false;
//		}
//		if (arr[n - 1] > sum) {
//			return subset(arr, n - 1, sum);
//		}
//		return subset(arr, n - 1, sum) || subset(arr, n - 1, sum - arr[n - 1]);
//	}

	public static boolean sub(int arr[], int n, int sum) {
		boolean ans[][] = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= n; i++) {
			ans[i][0] = true;
		}
		for (int j = 1; j <= sum; j++) {
			ans[0][j] = false;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {

				if (arr[i - 1] > j) {
					ans[i][j] = ans[i - 1][j];
				} else {
					ans[i][j] = ans[i - 1][j] || ans[i - 1][j - arr[i - 1]];
				}

			}
		}
		return ans[n][sum];
	}
}
