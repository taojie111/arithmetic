package hot100;

import java.util.*;

/**
 * @author taojie
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] param = new int[]{3,5,2};
        List<List<Integer>> result = doTest(param, 8);
        System.out.println(result);
    }

    public static List<List<Integer>> doTest(int[] candidates, int target) {
        LinkedList<Integer> trace = new LinkedList<>();
        dfs(candidates, target, trace);
        return result;
    }

    public static int sum = 0;

    public static List<List<Integer>> result = new ArrayList<>();

    public static void dfs(int[] candidates, int target, LinkedList<Integer> trace) {
        if (sum == target) {
            boolean isAdd = true;
            for (List<Integer> list : result) {
                if (list.size() == trace.size()) {
                    isAdd = false;
                    break;
                }
            }
            if (isAdd) {
                result.add(new LinkedList<>(trace));
            }
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            int candidate = candidates[i];
            sum += candidate;
            trace.add(candidate);
            dfs(candidates, target, trace);
            sum -= trace.getLast();
            trace.removeLast();
        }
    }
}
