package hot100;

import java.util.Arrays;

/**
 * @author taojie
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] param = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = doTest(param);
        System.out.println(result);
    }

    // 定义状态：f(x)是当x=index时，最大的连续子数组和
    // 定义状态转义方程：f(x) = max{arr[x],f(x - 1) + arr[x]}
    // 定义初始值：f(0) = arr[0]
    public static int doTest(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        Arrays.sort(dp);
        return dp[nums.length - 1];
    }
}
