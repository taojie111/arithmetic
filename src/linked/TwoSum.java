package linked;

/**
 * @author taojie
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] param = new int[]{2,5,6,7,11,15,17,18,23};
        int[] result = doTest(param, 170);
        System.out.println(result);
    }

    public static int[] doTest(int[] param, int target) {
        int start = 0;
        int end = start + 1;
        int[] result = new int[2];
        while (start < param.length && end < param.length) {
            if (param[start] + param[end] == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }
            if (param[start] + param[end] < target) {
                if (end == param.length - 1) {
                    start++;
                    end = start + 1;
                } else {
                    end++;
                }
            } else {
                return result;
            }
        }
        return result;
    }
}
