package wrong;

import java.util.List;

/**
 * @author taojie
 */
public class CanFinish {

    public static void main(String[] args) {
        int[][] param = new int[8][2];
        param[0] = new int[]{3,1};
        param[1] = new int[]{5,1};
        param[2] = new int[]{6,1};
        param[3] = new int[]{1,2};
        param[4] = new int[]{3,2};
        param[5] = new int[]{6,4};
        param[6] = new int[]{5,6};
        param[7] = new int[]{7,6};
        boolean result = canFinish(7, param);
        System.out.println(result);
    }

    static List<List<Integer>> edges;
    static int[] visited;
    static boolean valid = true;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        return true;
    }

    public static void dfs(int u) {

    }

}
