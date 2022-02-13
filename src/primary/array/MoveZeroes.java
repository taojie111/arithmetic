package primary.array;

/**
 * @author taojie
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] param = new int[]{1,1,0,0,0,12,6,3,0,0,2,1,0,2,3,8};
        int[] result = doTest2(param);
        System.out.println(result);
    }

    public static int[] doTest(int[] param) {
        int p = 0;
        int zeroCount = 0;
        while (p < param.length) {
            if (param[p] == 0) {
                zeroCount++;
            } else {
                if (zeroCount != 0) {
                    swap(param, p - zeroCount, p);
                }
            }
            p++;
        }
        return param;
    }

    public static int[] doTest2(int[] param) {
        int left = 0;
        int right = 0;
        while (right < param.length) {
            if (param[right] == 0) {
                right++;
            } else {
                swap(param, left, right);
                right++;
                left++;
            }
        }
        return param;
    }

    public static void swap(int[] nums, int left, int right) {
        int valueL = nums[left];
        int valueR = nums[right];
        valueL = valueL ^ valueR;
        valueR = valueL ^ valueR;
        valueL = valueL ^ valueR;
        nums[left] = valueL;
        nums[right] = valueR;
    }
}
