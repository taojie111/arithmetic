package wrong;

public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] param = new int[]{1,1,0,1,1,1};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        int len = nums.length;
        int index = 0;
        int result = 0;
        int count = 0;
        while (index < len) {
            if (nums[index] == 1) {
                count++;
                index++;
            } else {
                result = Math.max(result, count);
                count = 0;
                index++;
            }
        }
        return Math.max(result, count);
    }

    public static int doTest2(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int result = 0;
        int count = 0;
        while (right < len) {
            if (nums[right] == 1) {
                count++;
                right++;
            }
        }
        return result;
    }

}
