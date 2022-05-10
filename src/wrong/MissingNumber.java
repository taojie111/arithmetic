package wrong;

public class MissingNumber {

    public static void main(String[] args) {
        int[] param = new int[]{3,0,1};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        int n = nums.length;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            sum1 += num;
        }
        for (int i = 0; i <= n; i++) {
            sum2 += i;
        }
        return sum2 - sum1;
    }

}
