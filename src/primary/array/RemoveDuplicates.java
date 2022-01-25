package primary.array;

/**
 * @author taojie
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] param = new int[]{1,1,1,2,3,3,5};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
