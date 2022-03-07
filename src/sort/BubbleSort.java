package sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] param = new int[]{1,5,4,3,2,8,15,36,17,28};
        long start = System.currentTimeMillis();
        int[] result = doTest2(param);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int[] doTest(int[] param) {
        for (int i = 0; i < param.length; i++) {
            for (int j = 0; j < param.length - 1 - i; j++) {
                int pre = param[j];
                int after = param[j + 1];
                if (pre > after) {
                    param[j] = after;
                    param[j + 1] = pre;
                }
            }
        }
        return param;
    }

    public static int[] doTest2(int[] param) {
        for (int i = 0; i < param.length; i++) {
            for (int j = i+1; j < param.length; j++) {
                if (param[i] > param[j]) {
                    int temp = param[i];
                    param[i] = param[j];
                    param[j] = temp;
                }
            }
        }
        return param;
    }

}
