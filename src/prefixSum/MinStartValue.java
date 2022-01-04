package prefixSum;

public class MinStartValue {

    public static void main(String[] args) {
        int[] param = new int[]{1,-2,-3};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        int preSum = 0;
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = preSum + nums[i];
            min = Math.min(currentSum, min);
            preSum = currentSum;
        }
        return Math.abs(min) + 1;
    }
}
