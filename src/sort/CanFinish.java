package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taojie
 */
public class CanFinish {

    public static void main(String[] args) {
        int[][] param = new int[1][2];
        param[0] = new int[]{1,0};
        boolean result = canFinish(2, param);
        System.out.println(result);
    }

    static List<List<Integer>> edges;
    static int[] visited;
    static boolean valid = true;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public static void dfs(int u) {
        visited[u] = 1;
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }

}
