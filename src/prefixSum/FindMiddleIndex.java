package prefixSum;

import java.util.Arrays;

public class FindMiddleIndex {

    public static void main(String[] args) {
        int[] param = new int[]{2,3,-1,8,4};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        int result = Integer.MAX_VALUE;
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (prefixSum[i] == prefixSum[prefixSum.length - 1] - prefixSum[i + 1]) {
                result = Math.min(result, i);
            }
        }
        return result;
    }

    public static int findMiddleIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

}
