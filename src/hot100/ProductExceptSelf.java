package hot100;

/**
 * @author taojie
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] param = new int[]{1,2,3,4};
        int[] result = doTest(param);
        System.out.println(result);
    }

    public static int[] doTest(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                n *= nums[j];
            }
            result[i] = n;
        }
        return result;
    }
}
