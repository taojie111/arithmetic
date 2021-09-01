package hot100;

public class UniquePaths {

    public static void main(String[] args) {
        int result = doTest(3,7);
        System.out.println(result);
    }

    static int count = 0;

    public static int doTest(int m, int n) {
        int[][] grid = new int[m][n];
        dfs(m, n, 0, 0);
        return count;
    }

    public static void dfs(int row, int col, int startRow, int startCol) {
        if (startRow == row - 1 && startCol == col - 1) {
            count++;
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                int moveB = startRow + 1;
                if (moveB < row) {
                    dfs(row, col, moveB, startCol);
                }
            } else {
                int moveR = startCol + 1;
                if (moveR < col) {
                    dfs(row, col, startRow, moveR);
                }
            }
        }
    }

    /**
    * 动态规划
    */
    public static int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
