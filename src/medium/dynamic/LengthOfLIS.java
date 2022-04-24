package medium.dynamic;

public class LengthOfLIS {

    public static void main(String[] args) {
        int[] param = new int[]{3,5,6,2,5,4,19,5,6,7,12};
        int result = lengthOfLIS(param);
        System.out.println(result);
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
