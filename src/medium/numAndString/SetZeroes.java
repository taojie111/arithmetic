package medium.numAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetZeroes {

    public static void main(String[] args) {
        int[][] param = new int[3][4];
        param[0] = new int[]{0,1,2,0};
        param[1] = new int[]{3,4,5,2};
        param[2] = new int[]{1,3,1,5};
        doTest(param);
        System.out.println("aaa");
    }

    public static void doTest(int[][] matrix) {
        Map<Integer, List<Integer>> map = new HashMap<>(16);
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int ele = matrix[i][j];
                if (ele == 0) {
                    if (map.containsKey(i)) {
                        map.get(i).add(j);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        map.put(i,list);
                    }
                }
            }
        }
        for (Map.Entry<Integer,List<Integer>> entry : map.entrySet()) {
            int rowIndex = entry.getKey();
            for (int colIndex : entry.getValue()) {
                int up = rowIndex - 1;
                int down = rowIndex + 1;
                int left = colIndex - 1;
                int right = colIndex + 1;
                while (up >= 0) {
                    matrix[up][colIndex] = 0;
                    up--;
                }
                while (down < row) {
                    matrix[down][colIndex] = 0;
                    down++;
                }
                while (left >= 0) {
                    matrix[rowIndex][left] = 0;
                    left--;
                }
                while (right < col) {
                    matrix[rowIndex][right] = 0;
                    right++;
                }
            }
        }
    }
}
