package sort;

/**
 * @author taojie
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] param = new int[]{1,5,4,3,2,8,15,36,17,28};
        long start = System.currentTimeMillis();
        int[] result = insertionSort(param);
        System.out.println(System.currentTimeMillis() - start);
    }

    // 自己的直接插入排序法
    public static int[] doTest(int[] param) {
        for (int i = 0; i < param.length - 1; i++) {
            int compare = param[i + 1];
            for (int j = i ; j >= 0; j--) {
                if (compare < param[j]) {
                    param[j + 1] = param[j];
                } else {
                    param[j + 1] = compare;
                    break;
                }
            }
        }
        return param;
    }

    public static int[] insertionSort(int[] param) {
        for (int i = 1; i < param.length; i++) {
            int compare = param[i];
            int index = i - 1;
            while (index >= 0 && compare < param[index]) {
                param[index + 1] = param[index];
                index--;
            }
            param[index + 1] = compare;
        }
        return param;
    }


}
