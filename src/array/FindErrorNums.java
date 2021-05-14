package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taojie
 */
public class FindErrorNums {

    public static void main(String[] args) {
        int[] param = new int[]{1,4,2,2};
        int[] result = doFindErrorNums(param);
        System.out.println(result);
    }

    public static int[] doTest(int[] param) {
        int[] result = new int[2];
        int length = param.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.get(param[i]) != null && map.get(param[i]) != 0) {
                result[0] = param[i];
                result[1] = i + 1;
                break;
            }
            map.put(param[i],map.getOrDefault(param[i],0) + 1);
        }
        return result;
    }

    public static int[] doFindErrorNums(int[] nums) {
        int dup = -1, missing = 1;
        for (int n: nums) {
            if (nums[Math.abs(n) - 1] < 0) {
                dup = Math.abs(n);
            } else {
                nums[Math.abs(n) - 1] *= -1;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }
        return new int[]{dup, missing};
    }

}
