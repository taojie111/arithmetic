package array;

public class GetConcatenation {

    public static void main(String[] args) {
        int[] param = new int[]{1,2,1};
        int[] result = doTest(param);
        System.out.println(result);
    }

    public static int[] doTest(int[] nums) {
        int[] result = new int[2*nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[i + nums.length] = nums[i];
        }
        return result;
    }

}
