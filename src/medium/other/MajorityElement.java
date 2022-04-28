package medium.other;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int[] param = new int[]{3,2,3};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>(16);
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > (len / 2)) {
                return num;
            }
        }
        return 0;
    }

    public static int doTest2(int[] nums) {
        int len = nums.length;
        int max = 0;
        int cur = 0;
        for (int i = 0; i < len; i++) {
            int num = nums[i];

        }
        return 0;
    }
}
