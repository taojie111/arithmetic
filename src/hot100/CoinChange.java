package hot100;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] param = new int[]{1, 2, 5};
        int result = doTest(param, 11);
        System.out.println(result);
    }

    public static int doTest(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
