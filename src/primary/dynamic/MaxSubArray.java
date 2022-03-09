package primary.dynamic;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] param = new int[]{-1,-2};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < length; i++) {
            dp[i] = dp[i - 1] < 0 ? nums[i] : dp[i - 1] + nums[i];
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
