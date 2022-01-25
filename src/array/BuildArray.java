package array;

/**
 * @author taojie
 */
public class BuildArray {

    public static void main(String[] args) {
        int[] param = new int[]{0,2,1,5,3,4};
        int[] result = buildArray(param);
        System.out.println(result);
    }

    public static int[] doTest(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[nums[i]];
        }
        return result;
    }

    public static int[] buildArray(int[] nums) {
        int n = nums.length;
        // 第一次遍历编码最终值
        for (int i = 0; i < n; ++i){
            nums[i] += 1000 * (nums[nums[i]] % 1000);
        }
        // 第二次遍历修改为最终值
        for (int i = 0; i < n; ++i){
            nums[i] /= 1000;
        }
        return nums;
    }
}
