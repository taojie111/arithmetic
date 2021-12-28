package hot100;

import java.util.Deque;
import java.util.LinkedList;

public class MaximalRectangle {

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
        int result = maximalRectangle(param);
        System.out.println(result);
    }

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        // 对于每一列，使用基于柱状图的方法
        for (int j = 0; j < n; j++) {
            int[] up = new int[m];
            int[] down = new int[m];

            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }

}
