package hot100;

/**
 * @author taojie
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] param = new int[]{7,1,5,3,6,4};
        int result = doTest(param);
        System.out.println(result);
    }

    // f(x)(y)表示第x天的最大利润，y表示持有股票和不持有股票
    public static int doTest(int[] prices) {
        int[][] dp = new int[prices.length][2];
        int max = 0;
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        max = Math.max(max, Math.max(dp[0][0], dp[0][1]));
       /* dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0]-prices[1]);
        max = Math.max(max, Math.max(dp[1][0], dp[1][1]));*/
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }

}
