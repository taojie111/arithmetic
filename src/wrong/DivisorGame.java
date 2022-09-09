package wrong;

public class DivisorGame {

    public static void main(String[] args) {
        boolean result = doTest2(5);
        System.out.println(result);
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

}
