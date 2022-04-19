package medium.dynamic;

public class CanJump {

    public static void main(String[] args) {
        int[] param = new int[]{0};
        boolean result = doTest(param);
        System.out.println(result);
    }

    public static boolean doTest(int[] nums) {
        int length = nums.length;
        boolean[][] dp = new boolean[length][length];
        dp[0][0] = true;
        boolean isReach = true;
        for (int i = 0; i < length; i++) {
            if (!isReach) {
                continue;
            }
            if (nums[i] == 0) {
                if (i + 1 < length) {
                    isReach = isReach(dp, i + 1);
                }
                dp[i][i] = true;
                continue;
            }
            int count = i + nums[i];
            if (count >= length - 1) {
                return true;
            }
            for (int j = i; j <= count && j < length; j++) {
                dp[i][j] = true;
            }
        }
        return isReach(dp, length - 1);
    }

    public static boolean isReach(boolean[][] dp, int y) {
        for (int x = 0; x <= y; x++) {
            if (dp[x][y]) {
                return true;
            }
        }
        return false;
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
