package unionFind;

import java.util.Arrays;

/**
 * @author taojie
 */
public class FindCircleNum {

    public static void main(String[] args) {
        int[][] param = new int[3][3];
        param[0] = new int[]{1,0,0};
        param[1] = new int[]{0,1,0};
        param[2] = new int[]{0,0,1};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[][] isConnected) {
        int row = isConnected.length;
        int col = isConnected[0].length;
        int[] parent = new int[row];
        for (int i = 0; i < row; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isConnected[i][j] == 1) {
                    if (find(parent,i) != find(parent,j)) {
                        union(parent, i, j);
                    }
                }
            }

        }
        return (int) Arrays.stream(parent).distinct().count();
    }

    public static int find(int[] parent, int index) {
        if (index == parent[index]) {
            return parent[index];
        }
        return find(parent, parent[index]);
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }
}
