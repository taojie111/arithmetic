package hot100;

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

    static List<List<Integer>> result = new ArrayList<>();

    static LinkedList<Integer> element = new LinkedList<>();

    public static List<List<Integer>> doTest(int[] nums) {
        dfs(nums);
        return result;
    }

    public static void dfs(int[] nums) {
        if (element.size() == nums.length) {
            result.add(new LinkedList<>(element));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (element.contains(nums[i])) {
                continue;
            }
            element.add(nums[i]);
            dfs(nums);
            element.removeLast();
        }
    }
}
