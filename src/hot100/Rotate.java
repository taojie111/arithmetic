package hot100;

public class Rotate {

    public static void main(String[] args) {
        int[][] param = new int[3][3];
        int[] r0 = new int[]{1, 2, 3};
        int[] r1 = new int[]{4, 5, 6};
        int[] r2 = new int[]{7, 8, 9};
        param[0] = r0;
        param[1] = r1;
        param[2] = r2;
        int[][] result = rotate(param);
        System.out.println(result);
    }


    public static int[][] doTest(int[][] matrix) {
        int[][] temp = new int[3][3];
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                temp[j][length - i - 1] = matrix[j][length - i - 1];
                if (temp[i][j] == 0) {
                    matrix[j][length - i - 1] = matrix[i][j];
                } else {
                    matrix[j][length - i - 1] = temp[i][j];
                }
            }
        }
        return matrix;
    }

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
        return matrix;
    }

}
