package medium.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MajorityElement {

    public static void main(String[] args) {
        int[] param = new int[]{3,2,3};
        int result = majorityElement2(param);
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

    public static int majorityElement2(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    private static int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private static int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
