package hash;

import java.util.*;

// 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
// 示例：输入：nums = [2,7,11,15], target = 9，输出：[0,1]，解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
public class TwoSum {

    public static void main(String[] args) {
        int[] param = new int[]{2,7,11,15};
        int target = 13;
        Set<Integer> result = twoSum(param, target);
        System.out.println(result);
    }

    // 自己的解法
    public static Set<Integer> doTwoSum(int[] arr, int target) {
        Set<Integer> result = new HashSet<>();
        int length = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<length; i++) {
            map.put(i,arr[i]);
        }
        for (int i=0; i<length; i++) {
            int m = arr[i];
            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                if (entry.getKey() > i) {
                    int n = m + entry.getValue();
                    if (n == target) {
                        result.add(i);
                        result.add(entry.getKey());
                        return result;
                    }
                }
            }
        }
        return null;
    }

    // 官方解法
    public static Set<Integer> twoSum(int[] arr, int target) {
        Set<Integer> result = new HashSet<>();
        int length = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<length; i++) {
            if (map.containsKey(target - arr[i])) {
                result.add(i);
                result.add(map.get(target - arr[i]));
                return result;
            }
            map.put(arr[i],i);
        }
        return null;
    }
}
