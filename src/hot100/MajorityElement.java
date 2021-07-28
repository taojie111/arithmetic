package hot100;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int[] param = new int[]{2,2,1,1,1,2,2};
        int result = doTest1(param);
        System.out.println(result);
    }

    public static int doTest1(int[] nums) {
        Map<Integer, Integer> map =new HashMap<>(16);
        for (int i : nums) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        int target = nums.length / 2;
        for (int key : map.keySet()) {
            if (map.get(key) > target) {
                return key;
            }
        }
        return 0;
    }

    public static int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private static int majorityElementRec(int[] nums, int l, int h) {
        if (l == h) {
            return nums[l];
        }

        int mid = (h - l) / 2 + l;
        int left = majorityElementRec(nums, l, mid);
        int right = majorityElementRec(nums, mid + 1, h);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, l, h);
        int rightCount = countInRange(nums, right, l, h);

        return leftCount > rightCount ? left : right;
    }

    private static int countInRange(int[] nums, int num, int l, int h) {
        int count = 0;
        for (int i = l; i <= h; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

}
