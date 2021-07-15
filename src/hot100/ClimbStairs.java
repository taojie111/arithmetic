package hot100;

/**
 * @author taojie
 */
public class ClimbStairs {

    public static void main(String[] args) {
        int result = climbStairs(4);
        System.out.println(result);
    }

    // 定义状态：f(x)是台阶数=x时，爬到楼顶的方法数
    // 定义状态转义方程：f(x) = f(x-2) + f(x-1)
    // 定义初始值：f(1) = 1, f(2) = 2
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

}
