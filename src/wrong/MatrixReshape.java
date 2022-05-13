package wrong;

public class MatrixReshape {

    public static void main(String[] args) {
        int[][] param = new int[2][2];
        param[0] = new int[]{1, 2};
        param[1] = new int[]{3, 4};
        int[][] result = doTest(param, 1, 4);
        System.out.println(result);
    }

    public static int[][] doTest(int[][] mat, int r, int c) {
        int[][] result = new int[r][c];
        int r0 = mat.length;
        int c0 = mat[0].length;
        if (r0 * c0 != r * c) {
            return mat;
        }
        int rMark = 0;
        int cMark = 0;
        for (int i = 0; i < r0; i++) {
            for (int j = 0; j < c0; j++) {
                int e0 = mat[i][j];
                if (cMark == c) {
                    cMark = 0;
                    rMark++;
                }
                result[rMark][cMark++] = e0;
            }
        }
        return result;
    }

}
