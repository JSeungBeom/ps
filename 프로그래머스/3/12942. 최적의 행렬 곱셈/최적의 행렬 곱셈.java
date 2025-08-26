import java.util.Arrays;

class Solution {

    static int[][] dp;
    static int[] p;

    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;

        p = new int[n + 1];
        p[0] = matrix_sizes[0][0];
        for (int i = 0; i < n; i++) {
            p[i + 1] = matrix_sizes[i][1];
        }

        dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(0, n - 1);
    }

    static int solve(int i, int j) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int best = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left = solve(i, k);
            int right = solve(k + 1, j);
            int mergeCost = p[i] * p[k + 1] * p[j + 1];
            best = Math.min(best, left + right + mergeCost);
        }
        return dp[i][j] = best;
    }
}
