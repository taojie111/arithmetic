package medium.dynamic;

public class LengthOfLIS {

    public static void main(String[] args) {
        int[] param = new int[]{3,5,6,2,5,4,19,5,6,7,12};
        int result = lengthOfLIS(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        int max = nums[0];
        int second = Integer.MIN_VALUE;
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if (num < max) {
                if (num > second) {
                    max = num;
                }
                dp[i] = dp[i - 1];
            } else if (num > max) {
                second = max;
                max = num;
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[length - 1];
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}
