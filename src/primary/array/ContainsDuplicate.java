package primary.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] param = new int[]{1,1,1,3,3,4,3,2,4,2};
        boolean result = doTest(param);
        System.out.println(result);
    }

    public static boolean doTest(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(nums[i], 0) > 0) {
                return true;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return false;
    }
}
