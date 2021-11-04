package hot100;

import java.util.Arrays;

/**
 * @author taojie
 */
public class FindUnsortedSubarray {

    public static void main(String[] args) {
        int[] param = new int[]{2,6,4,8,10,9,15};
        int result = findUnsortedSubarray(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        return 0;
    }

    public static int findUnsortedSubarray(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);
        Arrays.sort(numsSorted);
        int left = 0;
        while (nums[left] == numsSorted[left]) {
            left++;
        }
        int right = nums.length - 1;
        while (nums[right] == numsSorted[right]) {
            right--;
        }
        return right - left + 1;
    }

    public static boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

}
