package hot100;

public class MaximalSquare {

    public static void main(String[] args) {
        char[][] param = new char[4][5];
        char[] r0 = new char[]{'1', '0', '1', '0', '0'};
        char[] r1 = new char[]{'1', '0', '1', '1', '1'};
        char[] r2 = new char[]{'1', '1', '1', '1', '1'};
        char[] r3 = new char[]{'1', '0', '0', '1', '1'};
        param[0] = r0;
        param[1] = r1;
        param[2] = r2;
        param[3] = r3;
        int result = maximalSquare(param);
        System.out.println(result);
    }

    public static int doTest(char[][] matrix) {
        int result = 0;
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                char c = matrix[i][j];
                if (c == '1') {
                    int hLen = getHorizontalLength(matrix, i, j);
                    int vLen = getVerticalLength(matrix, i, j);
                    int side = Math.min(hLen, vLen);
                    for (int k = 0; k < side - 1; k++) {
                        int startRow = i + k;
                        int startCol = j + k;
                        while (startRow < i + side && startCol < i +  side) {
                            startRow++;
                            startCol++;
                        }
                    }

                    int area = side * side;
                    if (side == 1) {
                        result = Math.max(result, area);
                    }
                }
            }
        }
        return 0;
    }

    public static int getHorizontalLength(char[][] matrix, int rowIndex, int colIndex) {
        int count = 1;
        for (int i = colIndex + 1; i < matrix[0].length; i++) {
            char c = matrix[rowIndex][i];
            if (c == '1') {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }

    public static int getVerticalLength(char[][] matrix, int rowIndex, int colIndex) {
        int count = 1;
        char value = matrix[rowIndex][colIndex];
        for (int i = rowIndex + 1; i < matrix.length; i++) {
            char c = matrix[i][colIndex];
            if (c == '1') {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }

    public static int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    // 遇到一个 1 作为正方形的左上角
                    maxSide = Math.max(maxSide, 1);
                    // 计算可能的最大正方形边长
                    int currentMaxSide = Math.min(rows - i, columns - j);
                    for (int k = 1; k < currentMaxSide; k++) {
                        // 判断新增的一行一列是否均为 1
                        boolean flag = true;
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }
                        for (int m = 0; m < k; m++) {
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

}
