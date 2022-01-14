package unionFind;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] param = new int[8][13];
        param[0] = new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        param[1] = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0};
        param[2] = new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        param[3] = new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0};
        param[4] = new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0};
        param[5] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        param[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0};
        param[7] = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int count = 0;
    public static int[] visit = null;

    public static int doTest(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] parent = new int[row * col];
        visit = new int[row * col];
        for (int i = 0; i < row * col; i++) {
            parent[i] = grid[i / col][i % col];
        }
        int result = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == 1) {
                dfs(parent, i, row, col);
            }
            result = Math.max(result, count);
            count = 0;
        }
        return result;
    }

    // 向上:index - col 向下:index + col 向左:index - 1 向右:index + 1
    public static void dfs(int[] parent, int index, int row, int col) {
        if (parent[index] == 0 || visit[index] == 1) {
            return;
        }
        if (parent[index] == 1) {
            count++;
            visit[index] = 1;
        }
        // 向上递归
        if (index - col >= 0) {
            dfs(parent,index - col, row, col);
        }
        // 向右递归
        if (index % col + 1 <= col - 1) {
            dfs(parent,index + 1, row, col);
        }

        // 向下递归
        if (index + col <= row * col - 1) {
            dfs(parent,index + col, row, col);
        }

        // 向左递归
        if (index % col - 1 >= 0) {
            dfs(parent,index - 1, row, col);
        }

    }

}
