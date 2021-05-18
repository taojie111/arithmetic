package sort;

/**
 * @author taojie
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] param = new int[]{1,5,4,3,2,8,15,36,17,28};
        long start = System.currentTimeMillis();
        int[] result = doTest(param);
        System.out.println(System.currentTimeMillis() - start);
    }

    //  执行length - 1趟，每趟查找最小值，并且和第i趟的值交换
    public static int[] doTest(int[] param) {
        int[] res = new int[param.length];
        for (int i = 0; i < param.length - 1; i++) {
            int min = param[i];
            int pos = i;
            for (int j = i + 1; j < param.length; j++) {
                if (param[j] < min) {
                    min = param[j];
                    pos = j;
                }
            }
            param[pos] = param[i];
            param[i] = min;
        }
        return param;
    }
}
