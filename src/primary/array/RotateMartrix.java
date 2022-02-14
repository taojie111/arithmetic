package primary.array;

public class RotateMartrix {

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
        // 水平翻转
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row - i - 1][j];
                matrix[row - i - 1][j] = temp;
            }
        }
        // 交换对角线
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }

}
