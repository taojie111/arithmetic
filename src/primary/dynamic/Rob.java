package primary.dynamic;

/**
 * @author taojie
 */
public class Rob {

    public static void main(String[] args) {
        int[] param = new int[]{2,1,1,2};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int result = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
            int max = Math.max(dp[i][0], dp[i][1]);
            result = Math.max(result, max);
        }
        return result;
    }
}
