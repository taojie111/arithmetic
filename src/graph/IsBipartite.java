package graph;

import java.util.Arrays;

public class IsBipartite {

    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private static int[] color;
    private static boolean valid;

    public static void main(String[] args) {
        int[][] param = new int[4][];
        param[0] = new int[]{1,3};
        param[1] = new int[]{0,2};
        param[2] = new int[]{1,3};
        param[3] = new int[]{0,2};
        boolean result = doTest(param);
        System.out.println(result);
    }

    public static boolean doTest(int[][] graph) {
        int n = graph.length;
        valid = true;
        color = new int[n];
        Arrays.fill(color, UNCOLORED);
        for (int i = 0; i < n && valid; ++i) {
            if (color[i] == UNCOLORED) {
                dfs(i, RED, graph);
            }
        }
        return valid;
    }

    // 1、功能：判断是否是二分图
    // 2、递归结束条件：数组循环完成，或者数组节点颜色等于相邻的节点颜色
    // 3、函数等价关系式:返回void，无等价关系式
    public static void dfs(int node, int c, int[][] graph) {
        color[node] = c;
        int cNei = c == RED ? GREEN : RED;
        for (int neighbor : graph[node]) {
            if (color[neighbor] == UNCOLORED) {
                dfs(neighbor, cNei, graph);
                if (!valid) {
                    return;
                }
            } else if (color[neighbor] != cNei) {
                valid = false;
                return;
            }
        }
    }

}
