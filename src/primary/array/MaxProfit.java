package primary.array;

public class MaxProfit {

    public static void main(String[] args) {
        int[] param = new int[]{7,1,5,3,6,4};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] +  prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] -  prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }
}
