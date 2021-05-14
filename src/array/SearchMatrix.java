package array;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] param = new int[5][5];
        param[0] = new int[]{1,4,7,11,15};
        param[1] = new int[]{2,5,8,12,19};
        param[2] = new int[]{3,6,9,16,22};
        param[3] = new int[]{10,13,14,17,24};
        param[4] = new int[]{18,21,23,26,30};
        boolean result = searchMatrix(param, 56);
        System.out.println(result);
    }

    public static boolean doTest(int[][] param, int target) {
        for (int i = 0; i<25; ++i) {
            if (param[i/5][i%5] == target) {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int l = start;
        int r = vertical ? matrix[0].length-1 : matrix.length-1;

        while (l <= r) {
            int mid = (l + r)/2;
            // searcrng a column
            if (vertical) {
                if (matrix[start][mid] < target) {
                    l = mid + 1;
                } else if (matrix[start][mid] > target) {
                    r = mid - 1;
                } else {
                    return true;
                }
            } else { // searcrng a row
                if (matrix[mid][start] < target) {
                    l = mid + 1;
                } else if (matrix[mid][start] > target) {
                    r = mid - 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // iterate over matrix diagonals
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }

        return false;
    }

}
