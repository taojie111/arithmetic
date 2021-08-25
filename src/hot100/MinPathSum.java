package hot100;

/**
 * @author taojie
 */
public class MinPathSum {

    public static void main(String[] args) {
        int[][] param = new int[3][3];
        int[] r0 = new int[]{1, 3, 1};
        int[] r1 = new int[]{1, 5, 1};
        int[] r2 = new int[]{1, 2, 1};
        param[0] = r0;
        param[1] = r1;
        param[2] = r2;
        int result = doTest(param);
        System.out.println(result);
    }

    static int min = 0;

    public static int doTest(int[][] grid) {
        dfs(grid, 0, 0, 0);
        return min;
    }

    public static void dfs(int[][] grid, int startRow, int startCol, int sum) {
        int row = grid.length;
        int col = grid[0].length;
        sum += grid[startRow][startCol];
        if (startRow == row-1 && startCol == col-1) {
            if (min == 0) {
                min = sum;
            } else {
                min = Math.min(min, sum);
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                int moveB = startRow + 1;
                if (moveB < row) {
                    dfs(grid, moveB, startCol, sum);
                }
            } else {
                int moveR = startCol + 1;
                if (moveR < row) {
                    dfs(grid, startRow, moveR, sum);
                }
            }

        }
    }
}
