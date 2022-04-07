package medium.backtrack;

public class Exist {

    public static void main(String[] args) {
        char[][] param = new char[3][4];
        char[] r0 = new char[]{'A', 'B', 'C', 'E'};
        char[] r1 = new char[]{'S', 'F', 'C', 'S'};
        char[] r2 = new char[]{'A', 'D', 'E', 'E'};
        param[0] = r0;
        param[1] = r1;
        param[2] = r2;
        boolean result = doTest(param, "SEE");
        System.out.println(result);
    }

    public static boolean doTest(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (ch == word.charAt(0)) {
                    boolean[][] sign = new boolean[board.length][board[0].length];
                    sign[i][j] = true;
                    if (dfs(board, sign, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] sign, String word, int row, int col, int index) {
        if (index == word.length() - 1) {
            return true;
        }
        for (int i = 1; i <= 4; i++) {
            int rIndex = 0;
            int cIndex = 0;
            if (i == 1) {
                rIndex = row - 1;
                cIndex = col;
            } else if (i == 2) {
                rIndex = row;
                cIndex = col + 1;
            } else if (i == 3) {
                rIndex = row + 1;
                cIndex = col;
            } else {
                rIndex = row;
                cIndex = col - 1;
            }
            if (rIndex < 0 || cIndex < 0 || rIndex >= board.length || cIndex >= board[0].length || sign[rIndex][cIndex]) {
                continue;
            }
            char c = board[rIndex][cIndex];
            if (c == word.charAt(index + 1)) {
                sign[rIndex][cIndex] = true;
                if (dfs(board, sign, word, rIndex, cIndex, index + 1)) {
                    return true;
                } else {
                    sign[rIndex][cIndex] = false;
                }
            }
        }
        return false;
    }
}
