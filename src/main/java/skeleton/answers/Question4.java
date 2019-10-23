package skeleton.answers;

public class Question4 {

	public static int choosingWisely(int[] v, int[] c, int mc) {
		int i;
		int n = v.length;
		int[][] K = new int[n + 1][mc + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (int w = 0; w <= mc; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (c[i - 1] <= w)
					K[i][w] = Math.max(v[i - 1] + K[i - 1][w - c[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[n][mc];
	}
}
