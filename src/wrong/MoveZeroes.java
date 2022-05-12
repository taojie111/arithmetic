package wrong;

/**
 * @author taojie
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] param = new int[]{0, 0, 1};
        doTest(param);
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

    public static void swap(int[] param, int pA, int pB) {
        param[pA] = param[pA] ^ param[pB];
        param[pB] = param[pA] ^ param[pB];
        param[pA] = param[pA] ^ param[pB];
    }
}
