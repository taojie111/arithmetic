package prefixSum;

public class MatrixBlockSum {

    public static void main(String[] args) {
        int[][] param = new int[3][3];
        param[0] = new int[]{1,2,3};
        param[1] = new int[]{4,5,6};
        param[2] = new int[]{7,8,9};
        int[][] result = doTest(param, 1);
        System.out.println(result);
    }

    public static int[][] doTest(int[][] mat, int k) {
        // i - k <= r <= i + k && j - k <= c <= j + k && (r, c)在矩阵内
        int[][] result = new int[3][3];
        return null;
    }
}
