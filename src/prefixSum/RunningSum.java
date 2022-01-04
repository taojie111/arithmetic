package prefixSum;

public class RunningSum {

    public static void main(String[] args) {
        int[] param = new int[]{3,1,2,10,1};
        int[] result = doTest(param);
        System.out.println(result);
    }

    // 使用常数空间复杂度
    public static int[] doTest(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
