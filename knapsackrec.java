package externalDaa;

public class knapsackrec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w[] = { 1, 2, 5, 6, 7 };
		int v[] = { 1, 6, 18, 22, 28 };
		int c = 11;
		System.out.println(dp(c, w, v, w.length));

	}

	public static int knap(int c, int w[], int v[], int n) {
		if (n == 0 || c == 0) {
			return 0;
		}
		if (w[n - 1] > c) {
			return knap(c, w, v, n - 1);
		}
		int nI = knap(c, w, v, n - 1);
		int I = knap(c - w[n - 1], w, v, n - 1) + v[n - 1];
		return Math.max(nI, I);
	}

	public static int dp(int c, int w[], int v[], int n) {

		int ans[][] = new int[w.length + 1][c + 1];
		for (int j = 0; j <= c; j++) {
			ans[0][j] = 0;
		}
		for (int i = 0; i <= w.length; i++) {
			ans[i][0] = 0;
		}
		for (int i = 1; i <= w.length; i++) {
			for (int j = 0; j <= c; j++) {

				if (w[i - 1] <= j) {
					ans[i][j] = Math.max(ans[i - 1][j], v[i - 1] + ans[i - 1][j - w[i - 1]]);
				} else {
					ans[i][j] = ans[i - 1][j];
				}

			}
		}
		return ans[w.length][c];

	}

}
