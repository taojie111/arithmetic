package hot100;

public class NumIslands {

    public static void main(String[] args) {
        char[][] param = new char[4][3];
        char[] r0 = new char[]{'1', '1', '1'};
        char[] r1 = new char[]{'0', '1', '0'};
        char[] r2 = new char[]{'1', '0', '0'};
        char[] r3 = new char[]{'1', '0', '1'};
        param[0] = r0;
        param[1] = r1;
        param[2] = r2;
        param[3] = r3;
        int result = numIslands(param);
        System.out.println(result);
    }

    public static int doTest(char[][] grid) {
        int result = 0;
        int[][] statusArr = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i];
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                int status = statusArr[i][j];
                if (aChar == '1' && status == 0) {
                    dfs(i, j, grid, statusArr);
                    result++;
                }
            }
        }
        return result;
    }

    public static void dfs(int i, int j, char[][] grid, int[][] statusArr) {
        if (i == grid.length || i == -1 || j == grid[0].length || j == -1) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        if (statusArr[i][j] == 1) {
            return;
        }
        if (grid[i][j] == '1') {
            statusArr[i][j] = 1;
        }
        dfs(i - 1, j, grid, statusArr);
        dfs(i + 1, j, grid, statusArr);
        dfs(i, j - 1, grid, statusArr);
        dfs(i, j + 1, grid, statusArr);
    }

    static class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        uf.union(r * nc + c, (r - 1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r + 1][c] == '1') {
                        uf.union(r * nc + c, (r + 1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c + 1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }
}
