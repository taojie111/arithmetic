package greed;

/**
 * @author taojie
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] param = new int[]{7,1,5,3,6,4};
        int result = maxProfit2(param);
        System.out.println(result);
    }

    // 贪心算法
    // 1、全局最优解：所有买入和卖出的差价相加
    // 2、局部最优解：只要卖出比买入高就是局部最优解
    // 3、合并局部解
    public static int maxProfit1(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    // 动态规划
    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

}
