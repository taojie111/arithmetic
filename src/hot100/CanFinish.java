package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taojie
 */
public class CanFinish {

    public static void main(String[] args) {
        int[][] param = new int[9][2];
        param[0] = new int[]{3,1};
        param[1] = new int[]{5,1};
        param[2] = new int[]{6,1};
        param[3] = new int[]{1,2};
        param[4] = new int[]{3,2};
        param[5] = new int[]{6,4};
        param[6] = new int[]{5,6};
        param[7] = new int[]{7,6};
        param[8] = new int[]{4,5};
        boolean result = doTest(7, param);
        System.out.println(result);
    }

    static List<Integer> vertex = new ArrayList<>();
    static Map<Integer, List<Integer>> edge = new HashMap<>();
    static boolean canFinish = true;
    static int count = 0;
    static Map<Integer, Integer> status = new HashMap<>();

    public static boolean doTest(int numCourses, int[][] prerequisites) {
        for (int i = 1; i <= numCourses; i++) {
            vertex.add(i);
            status.put(i, 1);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            if (edge.containsKey(prerequisite[1])) {
                edge.get(prerequisite[1]).add(prerequisite[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisite[0]);
                edge.put(prerequisite[1], list);
            }
        }
        for (int i = 0; i < vertex.size(); i++) {
            Integer v = vertex.get(i);
            dfs(v);
        }
        return canFinish;
    }

    public static void dfs(int v) {
        if (status.get(v) == 3) {
            return;
        }
        if (status.get(v) == 2) {
            canFinish = false;
            return;
        }
        status.put(v, 2);
        if (edge.get(v) != null) {
            for (int i: edge.get(v)) {
                if (status.get(i) == 2) {
                    canFinish = false;
                    return;
                }
                if (status.get(i) == 3) {
                    continue;
                }
                dfs(i);
            }
        }
        status.put(v, 3);
    }

}
