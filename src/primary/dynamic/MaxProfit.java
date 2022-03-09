package primary.dynamic;

public class MaxProfit {

    public static void main(String[] args) {
        int[] param = new int[]{7,1,5,3,6,4};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] prices) {
        int result = 0;
        int[][] dp = new int[prices.length][prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                dp[i][j] = Math.max(profit > 0 ? profit : 0, dp[i][j - 1]);
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

}
