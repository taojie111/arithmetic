package dynamicProgramming;

public class massage {

    public static void main(String[] args) {
        int[] param = new int[]{1,6};
        int result = doTest(param);
        System.out.println(result);
    }

    // 动态规划
    // 状态：f(n)表示以第n次号预约结尾的最长预约时间数
    // 边界：f(0) = arr[0]， f(1) = max{arr[1],arr[0]}
    // 状态转移方程：f(n) = max{f(n - 1), f(n - 2) + arr[n]}
    public static int doTest(int[] param) {
        int result = 0;
        int[] dp = new int[param.length];
        if (param.length == 1) {
            return param[0];
        }
        if (param.length == 2) {
            return Math.max(param[0], param[1]);
        }
        dp[0] = param[0];
        dp[1] = Math.max(param[0], param[1]);
        result = Math.max(result, dp[1]);
        for (int i = 2; i < param.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + param[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }



}
