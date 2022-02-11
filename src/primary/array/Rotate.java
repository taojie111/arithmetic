package primary.array;

public class Rotate {

    public static void main(String[] args) {
        int[] param = new int[]{-1,-100,3,99};
        int[] result = doTest2(param, 2);
        System.out.println(result);
    }

    public static int[] doTest(int[] nums, int k) {
        for (int i = 1; i <= k; i++) {
            int start = 0;
            int startTmp = nums[0];
            int currentTmp = 0;
            for (int j = 0; j < nums.length; j++) {
                int currentIndex = (start + 1) % nums.length;
                currentTmp = nums[currentIndex];
                nums[currentIndex] = startTmp;
                startTmp = currentTmp;
                start = currentIndex;
            }
        }
        return nums;
    }

    public static int[] doTest2(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % length] = nums[i];
        }
        return result;
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}
