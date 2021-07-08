package dynamicProgramming;

public class RotatedDigits {

    public static void main(String[] args) {
        int result = doTest(32);
        System.out.println(result);
    }

    public static int doTest(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + (isGoodNumber(i) ? 1 : 0);
        }
        return dp[n];
    }

    public static boolean isGoodNumber(int x) {
        String s = String.valueOf(x);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 50 || c == 53 || c == 54 || c == 57) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
