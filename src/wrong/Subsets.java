package wrong;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taojie
 */
public class Subsets {

    public static void main(String[] args) {
        int[] param = new int[]{1, 2, 3};
        List<List<Integer>> result = subsets(param);
        System.out.println(result.size());
        System.out.println(result.size() == dp(param));
        System.out.println(result.size() == doTest(param));
    }


    public static int doTest(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += process(nums, i);
        }
        return ans + 1;
    }

    public static int process(int[] nums, int index) {
        if (index == 0) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < index; i++) {
            ans += process(nums, i);
        }
        return ans + 1;
    }

    public static int dp(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 0) {
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 2 * dp[i - 1];
            ans += dp[i];
        }
        return ans + 1;
    }

    static List<Integer> t = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public static void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        int len = nums.length;
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int mask = 0; mask < (1 << len); mask++) {
            t.clear();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }
}
