package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taojie
 */
public class FindOrder {

    public static void main(String[] args) {
        int[][] param = new int[8][2];
        param[0] = new int[]{2,0};
        param[1] = new int[]{4,0};
        param[2] = new int[]{5,0};
        param[3] = new int[]{0,1};
        param[4] = new int[]{2,1};
        param[5] = new int[]{5,3};
        param[6] = new int[]{4,5};
        param[7] = new int[]{6,5};
        int[] result = doTest(7, param);
        System.out.println(result);
    }

    static boolean valid = true;
    static int index;
    static int[] result;
    static int[] visited;
    static List<List<Integer>> graph = new ArrayList<>();


    public static int[] doTest(int numCourses, int[][] prerequisites) {
        index = numCourses - 1;
        visited = new int[numCourses];
        result = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }
        return result;
    }

    public static void dfs(int u) {
        visited[u] = 1;
        for (int v : graph.get(u)) {
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
        result[index--] = u;
    }

}
