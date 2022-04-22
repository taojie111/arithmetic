package medium.dynamic;

public class UniquePaths {

    public static void main(String[] args) {
        int result = doTest(1,1);
        System.out.println(result);
    }

    public static int doTest(int m, int n) {
        if (m == n && m == 1) {
            return 1;
        }
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }

        }
        return dp[m][n];
    }
}
