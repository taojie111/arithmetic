package hot100;

/**
 * @author taojie
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] param = new int[]{1,1,0,0,0,12,6,3,0,0,2,1,0,2,3,8};
        int[] result = doTest(param);
        System.out.println(result);
    }

    public static int[] doTest(int[] param) {
        int pA = 0;
        int pB = 0;
        while (pB < param.length) {
            if (pA == pB && param[pA] > 0) {
                pA++;
                pB++;
            } else if (param[pB] == 0) {
                pB++;
            } else if (param[pB] != 0) {
                swap(param, pA, pB);
                pA++;
                pB++;
            }
        }
        return param;
    }

    public static void swap(int[] param, int pA, int pB) {
        param[pA] = param[pA]^param[pB];
        param[pB] = param[pA]^param[pB];
        param[pA] = param[pA]^param[pB];
    }
}
