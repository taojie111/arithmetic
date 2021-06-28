package dynamicProgramming;

public class Fib {

    public static void main(String[] args) {
        int result = doTest(5);
        System.out.println(result);
    }

    // 动态规划
    public static int doTest(int n) {
        int result = 0;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] =  dp[i - 1] +  dp[i - 2];
        }
        return dp[n - 1];
    }

}
