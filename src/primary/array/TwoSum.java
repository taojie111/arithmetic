package primary.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] param = new int[]{2,7,11,15};
        int[] result = doTest(param, 9);
        System.out.println(result);
    }

    public static int[] doTest(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(num, i);
        }
        return new int[0];
    }
}


