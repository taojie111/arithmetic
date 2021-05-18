package sort;

public class ShellSort {

    public static void main(String[] args) {
        int[] param = new int[]{1,5,4,3,2,8,15,36,17,28};
        long start = System.currentTimeMillis();
        int[] result = doTest(param);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int[] doTest(int[] param) {
        int gap = param.length / 2;
        while (gap > 0) {
            for (int i = gap; i < param.length; i++) {
                int compare = param[i];
                int index = i - gap;
                while (index >= 0 && param[index] > compare) {
                    param[index + gap] = param[index];
                    index -= gap;
                }
                param[index + gap] = compare;
            }
            gap /= 2;
        }
        return param;
    }

    public static int[] shellSort(int[] array) {
        int len = array.length;
        if(len == 0) {
            return array;
        }
        int current, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                current = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > current) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = current;
            }
            gap /= 2;
        }
        return array;
    }
}
