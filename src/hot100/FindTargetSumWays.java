package hot100;

/**
 * @author taojie
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        int[] param = new int[]{1,1,1,1,1};
        int result = doTest(param, 3);
        System.out.println(result);
    }

    private static int count = 0;

    private static int result = 0;

    public static int doTest(int[] nums, int target) {
        StringBuilder trace = new StringBuilder();
        dfs(nums, target, 0);
        return  result;
    }

    public static int doTest2(int[] nums, int target) {

        return  0;
    }

    public static void dfs(int[] nums, int target, int value) {
        int length = nums.length;
        if (count == length) {
            if (value == target) {
                result++;
            }
            return;
        }
        for (int i = 0; i < length; i++) {
            if (i != count) {
                continue;
            }
            int num = nums[i];
            for (int j = 1; j < 3; j++) {
                if (j == 1) {
                    value = value + num;
                } else {
                    value = value - num;
                }
                count++;
                dfs(nums, target, value);
                count--;
                if (j == 1) {
                    value = value - num;
                } else {
                    value = value + num;
                }
            }
        }
    }

    static int count2 = 0;

    public static int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count2;
    }

    public static void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count2++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }

    public static int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }
}
