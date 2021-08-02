package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] param = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> result = findDisappearedNumbers(param);
        System.out.println(result);
    }

    public static List<Integer> doTest(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        while (left < n) {
            int diff = 0;
            if (left == n - 1) {
                diff = n - nums[left];
                if (diff > 0) {
                    for (int i = 1; i <= diff; i++) {
                        list.add(nums[left] + i);
                    }
                }
            } else {
                diff = nums[left + 1] - nums[left];
                if (diff > 1) {
                    for (int i = 1; i < diff; i++) {
                        list.add(nums[left] + i);
                    }
                }
            }
            left++;
        }
        return list;
    }

    // 4,3,2,7,8,2,3,1
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

}
