package divideAndConquer;

public class MajorityElement {

    public static void main(String[] args) {
        int[] param = new int[]{1,4,1,1,5};
        int result = majorityElement(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        int length = nums.length;
        int n = length / 2;
        return 0;
    }

    public static int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private static int majorityElementRec(int[] nums, int l, int h) {
        if (l == h) {
            return nums[l];
        }

        int mid = (h - l) / 2 + l;
        int left = majorityElementRec(nums, l, mid);
        int right = majorityElementRec(nums, mid + 1, h);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, l, h);
        int rightCount = countInRange(nums, right, l, h);

        return leftCount > rightCount ? left : right;
    }

    private static int countInRange(int[] nums, int num, int l, int h) {
        int count = 0;
        for (int i = l; i <= h; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

}
