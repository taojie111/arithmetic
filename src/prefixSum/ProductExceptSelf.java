package prefixSum;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] param = new int[]{1,2,3,4};
        int[] result = doTest(param);
        System.out.println(result);
    }

    public static int[] doTest(int[] nums) {
        int[] reslut = new int[nums.length];
        int[] prefix = new int[nums.length+1];
        int[] suffix = new int[nums.length+1];
        prefix[0] = 1;
        suffix[nums.length] = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[i+1] = 1;
            } else {
                prefix[i + 1] = prefix[i] * nums[i - 1];
            }
    }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                suffix[i] = 1;
            } else {
                suffix[i] = suffix[i+1] * nums[i + 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            reslut[i] =  prefix[i+1] * suffix[i];
        }
        return reslut;
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }

}
