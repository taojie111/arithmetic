package primary.array;

import java.util.HashMap;
import java.util.Map;

public class IsValidSudoku {

    public static void main(String[] args) {
        char[][] param = new char[9][9];
        char[] r0 = new char[]{'5','3','.','.','7','.','.','.','.'};
        char[] r1 = new char[]{'6','.','.','1','9','5','.','.','.'};
        char[] r2 = new char[]{'.','9','8','.','.','.','.','6','.'};
        char[] r3 = new char[]{'8','.','.','.','6','.','.','.','3'};
        char[] r4 = new char[]{'4','.','.','8','.','3','.','.','1'};
        char[] r5 = new char[]{'7','.','.','.','2','.','.','.','6'};
        char[] r6 = new char[]{'.','6','.','.','.','.','2','8','.'};
        char[] r7 = new char[]{'.','.','.','4','1','9','.','.','5'};
        char[] r8 = new char[]{'.','.','.','.','8','.','.','7','9'};
        param[0] = r0;
        param[1] = r1;
        param[2] = r2;
        param[3] = r3;
        param[4] = r4;
        param[5] = r5;
        param[6] = r6;
        param[7] = r7;
        param[8] = r8;
        boolean result = isValidSudoku(param);
        System.out.println(result);
    }

    public static boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
