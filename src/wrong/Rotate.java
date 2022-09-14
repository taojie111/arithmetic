package wrong;

public class Rotate {

    public static void main(String[] args) {
        int[][] param = new int[3][3];
        int[] r0 = new int[]{1, 2, 3};
        int[] r1 = new int[]{4, 5, 6};
        int[] r2 = new int[]{7, 8, 9};
        param[0] = r0;
        param[1] = r1;
        param[2] = r2;
        int[][] result = doTest(param);
        System.out.println(result);
    }


    public static int[][] doTest(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < (row / 2); i++) {
            for (int j = 0; j < col; j++) {
                int sRow = row - 1 - i;
                int temp = matrix[sRow][j];
                matrix[sRow][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j <= i) {
                    continue;
                }
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        return matrix;
    }

}
