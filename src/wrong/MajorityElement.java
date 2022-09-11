package wrong;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int[] param = new int[]{2, 2, 1, 1, 1, 2, 2};
        int result = doTest1(param);
        System.out.println(result);
    }

    public static int doTest1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return Integer.MAX_VALUE;
    }

    public static int doTest2(int[] nums) {
        return process(nums,0,nums.length-1);
    }

    public static int process(int[] nums, int l, int r) {
        if (l == r) {
            return nums[r];
        }
        int m = l + (r - l) / 2;
        int left = process(nums, l, m);
        int right = process(nums, m + 1, r);
        if (left == right) {
            return left;
        }
        int lCount = countInRange(nums, left, l, r);
        int rCount = countInRange(nums, right, l, r);
        return lCount > rCount ? left : right;
    }

    public static int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
