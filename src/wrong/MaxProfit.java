package wrong;

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
        int maxProfit = 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            dp[i][0] = Math.max(dp[i - 1][1] + price, dp[i-1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i-1][0] - price);
            maxProfit = Math.max(dp[i][0], dp[i][1]);
        }
        return maxProfit;
    }

}
