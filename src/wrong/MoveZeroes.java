package wrong;

/**
 * @author taojie
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] param = new int[]{1, 6, 0, 3, 0, 0, 8};
        doTest(param);
        System.out.println(param);
    }

    public static void doTest(int[] nums) {
        int len = nums.length;
        int index = 0;
        while (index < len) {
            if (nums[index] != 0) {
                int cur = index;
                int temp = index - 1;
                while (temp >= 0 && nums[temp] == 0) {
                    swap(nums, cur, temp);
                    cur = temp;
                    temp--;
                }
            }
            index++;
        }
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] param, int pA, int pB) {
        param[pA] = param[pA] ^ param[pB];
        param[pB] = param[pA] ^ param[pB];
        param[pA] = param[pA] ^ param[pB];
    }
}
