package hot100;

public class MaxProduct {

    public static void main(String[] args) {
        int[] param = new int[]{-2,0,-1};
        int result = maxProduct(param);
        System.out.println(result);
    }

    public static int doTest(int[] param) {
        int length = param.length;
        int maxProd = 0;
        for (int i = 0; i < length; i++) {
            int pre = param[i];
            for (int j = i + 1; j < length; j++) {
                int n = param[j];
                maxProd = Math.max(pre * n, maxProd);
                pre = pre * n;
            }
        }
        return maxProd;
    }

    public static int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

}
