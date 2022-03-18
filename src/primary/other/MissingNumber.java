package primary.other;

import java.util.HashMap;
import java.util.Map;

public class MissingNumber {

    public static void main(String[] args) {
        int[] param = new int[]{3,0,1};
        int result = doTest3(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            map.put(i,1);
        }
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.get(nums[i]) - 1);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int doTest2(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < nums.length; j++) {
                int num = nums[j];
                if (i == num) {
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public static int doTest3(int[] nums) {
        int n = nums.length;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i <= n; i++) {
            sum1 += i;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum2 += num;
        }
        return sum1 - sum2;
    }

}
