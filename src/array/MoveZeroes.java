package array;

/**
 * @author taojie
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] param = new int[]{1,1,0,0,0,12,6,3,0,0,2,1,0,2,3,8};
        int[] result = doMoveZeroes(param);
        System.out.println(result);
    }

    public static int[] doMoveZeroes(int[] param) {
        int left = 0,right = 0;
        int n = param.length;
        while(right < n) {
            if (param[right] != 0 ) {
                // 交换
                swap(param, left, right);
                left++;
            }
            right++;
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
