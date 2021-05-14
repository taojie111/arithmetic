package array;

public class MatrixReshape {

    public static void main(String[] args) {
        int[][] param = new int[2][2];
        param[0] = new int[]{1,2,3};
        param[1] = new int[]{4,5,6};
        int[][] result = doMatrixReshape(param, 3, 2);
        System.out.println(result);
    }

    public static int[][] doMatrixReshape(int[][] param, int r, int c) {
        int[][] result = new int[r][c];
        int m = param.length;
        int n = param[0].length;
        if (m * n != r * c) {
            return param;
        }
        for (int x=0; x<m*n; ++x) {
            result[x/c][x%c] = param[x/n][x%n];
        }
        return result;
    }

}
