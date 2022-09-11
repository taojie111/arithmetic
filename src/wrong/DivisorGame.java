package wrong;

public class DivisorGame {

    public static void main(String[] args) {
        boolean result1 = doTest2(196);
        System.out.println(result1);
        boolean result2 = doTest3(196);
        System.out.println(result2);
        System.out.println(result1 == result2);
    }

    public static boolean doTest(int n) {
        return process(n, 1);
    }

    // n:黑板上的数，i：谁先手（1,2）
    public static boolean process(int n, int i) {
        if (n <= 1) {
            return false;
        }
        boolean isWin = false;
        for (int x = 1; x < n; x++) {
            if (n % x == 0) {
                if (!process(n - x, i == 1 ? 2 : 1)) {
                    isWin = true;
                    break;
                }
            }
        }
        return isWin;
    }

    public static boolean doTest2(int n) {
        boolean[][] dp = new boolean[n + 1][2];
        for (int i = 3; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int x = 1; x < i; x++) {
                    if (i % x == 0 && !dp[i - x][j == 0 ? 1 : 0]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        return dp[n][0];
    }

    public static boolean doTest3(int n) {
        int[] dp = new int[n+1];
        return p(n, dp);
    }

    public static boolean p(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n] == 1 ? false : true;
        }
        if (n <= 1) {
            dp[n] = 1;
            return false;
        }
        for (int x = 1; x < n; x++) {
            if (n % x == 0 && q(n - x,dp)) {
                dp[n] = 2;
                return true;
            }
        }
        dp[n] = 1;
        return false;
    }

    public static boolean q(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n] == 1 ? false : true;
        }
        if (n <= 1) {
            dp[n] = 2;
            return true;
        }
        for (int x = 1; x < n; x++) {
            if (n % x == 0 && !p(n - x,dp)) {
                dp[n] = 1;
                return false;
            }
        }
        dp[n] = 2;
        return true;
    }
}
