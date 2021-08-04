package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taojie
 */
public class Subsets {

    public static void main(String[] args) {
        int[] param = new int[]{1, 2, 3};
        List<List<Integer>> result = subsets2(param);
        System.out.println(result);
    }

    public static List<List<Integer>> doTest(int[] nums) {
        return null;
    }

    static List<Integer> t = new ArrayList<Integer>();

    static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }

    public static List<List<Integer>> subsets2(int[] nums) {
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

}
