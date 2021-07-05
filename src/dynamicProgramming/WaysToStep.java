package dynamicProgramming;

public class WaysToStep {

    public static void main(String[] args) {
        int result = doTest(5);
        System.out.println(result);
    }

    public static int doTest(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

}
