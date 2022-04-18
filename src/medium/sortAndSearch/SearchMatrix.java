package medium.sortAndSearch;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] param = new int[1][3];
        param[0] = new int[]{1,3,5};
        boolean result = doTest(param, 3);
        System.out.println(result);
    }

    public static boolean doTest(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row && i < col; i++) {
            if (binarySearch(matrix, target, i, false)) {
                return true;
            }
            if (binarySearch(matrix, target, i, true)) {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (vertical) {
            int up = start;
            int down = row - 1;
            while (up <= down) {
                int mid = up + (down - up) / 2;
                if (matrix[mid][start] == target) {
                    return true;
                } else if (matrix[mid][start] < target) {
                    up = mid + 1;
                } else {
                    down = mid - 1;
                }
            }
        } else {
            int left = start;
            int right = col - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[start][mid] == target) {
                    return true;
                } else if (matrix[start][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

}
