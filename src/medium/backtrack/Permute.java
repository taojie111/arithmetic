package medium.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author taojie
 */
public class Permute {

    public static void main(String[] args) {
        int[] param = new int[]{1, 2, 3};
        List<List<Integer>> result = doTest(param);
        System.out.println(result);
    }

    public static List<List<Integer>> doTest(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, new LinkedList<Integer>());
        return result;
    }

    public static void dfs(List<List<Integer>> result, int[] nums, LinkedList<Integer> trace) {
        if (trace.size() == nums.length) {
            result.add(new LinkedList<>(trace));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (trace.contains(nums[i])) {
                continue;
            }
            trace.add(nums[i]);
            dfs(result, nums, trace);
            trace.removeLast();
        }
    }
}
