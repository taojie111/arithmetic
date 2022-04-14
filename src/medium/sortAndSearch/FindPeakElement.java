package medium.sortAndSearch;

/**
 * @author taojie
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] param = new int[]{1, 2, 3, 5, 6, 1, 7, 8, 3};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int pre = Integer.MIN_VALUE;
            int after = Integer.MIN_VALUE;
            if (i != 0) {
                pre = nums[i - 1];
            }
            if (i != nums.length - 1) {
                after = nums[i + 1];
            }
            if (num >= pre && num >= after) {
                return i;
            }
        }
        return -1;
    }

    public static int doTest2(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
                ans = mid;
                break;
            }
            if (compare(nums, mid, mid + 1) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static int[] get(int[] nums, int idx) {
        if (idx == -1 || idx == nums.length) {
            return new int[]{0, 0};
        }
        return new int[]{1, nums[idx]};
    }

    public static int compare(int[] nums, int idx1, int idx2) {
        int[] num1 = get(nums, idx1);
        int[] num2 = get(nums, idx2);
        if (num1[0] != num2[0]) {
            return num1[0] > num2[0] ? 1 : -1;
        }
        if (num1[1] == num2[1]) {
            return 0;
        }
        return num1[1] > num2[1] ? 1 : -1;
    }

}
