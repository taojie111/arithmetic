package dynamicProgramming;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] param = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(param);
        System.out.println(result);
    }

    // 动态规划
    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
