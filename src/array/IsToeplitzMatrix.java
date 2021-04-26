package array;

/**
 * @author taojie
 */
public class IsToeplitzMatrix {

    public static void main(String[] args) {
        int[][] param = new int[3][4];
        param[0] = new int[]{1,2,3,4};
        param[1] = new int[]{5,1,2,3};
        param[2] = new int[]{9,5,1,2};
        boolean result = doTest(param);
        System.out.println(result);
    }

    public static boolean doTest(int[][] param) {
        int r = param.length;
        int c = param[0].length;
        for (int i = 1; i < r; ++i) {
            for (int j = 1; j < c; ++j) {
                if (param[i][j] != param[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

}
