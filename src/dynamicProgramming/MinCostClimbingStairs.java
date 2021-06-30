package dynamicProgramming;

/**
 * @author taojie
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] param = new int[]{10, 15, 20};
        int result = minCostClimbingStairs(param);
        System.out.println(result);
    }

    // 动态规划
    // 定义状态：f(x)(y)表示最后一次通过方式y爬到x阶台阶的最小花费,y=1表示最后一次爬1阶到达x，y=2表示最后一次爬2阶到达x
    // 定义边界：f(0)(0) = f(0)(1) = f(1)(0) = f(1)(1) = 0
    // 状态转移方程：f(x)(y) = max{f(x-2)(2) + arr[x-2],f(x-1)(1) + arr[x-1]}
    public static int doTest(int[] costs) {
        int length = costs.length;
        int[][] dp = new int[costs.length + 1][2];
        dp[0][0] = dp[0][1] = dp[1][0] = dp[1][1] = 0;
        for (int i = 2; i <= length; i++) {
            dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i - 1];
            dp[i][1] = Math.min(dp[i-2][0], dp[i-2][1]) + costs[i - 2];
        }
        return Math.min(dp[costs.length][0], dp[costs.length][1]);
    }

    // 定义状态：f(x)表示到达x阶的最小花费
    // 定义边界：f(0) = f(1) = 0;
    // 定义状态转移：f(x) = min{f(x-1) + arr[x-1], f(x-2) + arr[x-2]}
    public static int minCostClimbingStairs(int[] costs) {
        int length = costs.length;
        int[] dp = new int[length + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= length; i++) {
            dp[i] = Math.min(dp[i-1]+costs[i-1],dp[i-2]+costs[i-2]);
        }
        return dp[length];
    }

}
