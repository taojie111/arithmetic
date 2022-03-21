package medium.numAndString;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] param = new int[]{3,0,-2,-1,1,2};
        List<List<Integer>> result = doTest(param);
        System.out.println(result);
    }

    public static List<List<Integer>> doTest(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, track, used);
        return result;
    }

    public static List<List<Integer>> result = new ArrayList<>();

    public static void dfs(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == 3) {
            if (track.stream().mapToInt((e) -> e).sum() == 0) {
                if (check(track)) {
                    result.add(new LinkedList(track));
                }
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (used[i]) {
                continue;
            }
            used[i] = true;
            track.add(num);
            dfs(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }

    public static boolean check(LinkedList<Integer> track) {
        int count1 = 0;
        for (Integer i : track) {
            if (i == 0) {
                count1++;
            }
        }
        for (List<Integer> list : result) {
            boolean flag = true;
            int count2 = 0;
            for (Integer i : list) {
                if (i == 0) {
                    count2++;
                }
            }
            for (Integer i : track) {
                if (!list.contains(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag && count1 == count2) {
                return false;
            }
        }
        return true;
    }
}
