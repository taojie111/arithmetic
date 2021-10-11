package hot100;

import java.util.HashMap;

public class SubarraySum {

    public static void main(String[] args) {
        int[] param = new int[]{1, 2, 3, 4};
        int result = subarraySum(param, 6);
        System.out.println(result);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
