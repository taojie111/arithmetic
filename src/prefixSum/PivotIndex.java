package prefixSum;

public class PivotIndex {

    public static void main(String[] args) {
        int[] param = new int[]{1,7,3,6,5,6};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        int result = Integer.MAX_VALUE;

        int[] prefixSums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftSum = 0;
            } else {
                leftSum =  prefixSums[i];
            }

            if (i == nums.length - 1) {
                rightSum = 0;
            } else {
                rightSum =  prefixSums[nums.length] - prefixSums[i + 1];
            }

            if (leftSum == rightSum) {
                result = Math.min(result, i);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
