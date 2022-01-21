package unionFind;

/**
 * @author taojie
 */
public class FindRedundantConnection {

    public static void main(String[] args) {
        int[][] param = new int[5][2];
        param[0] = new int[]{1,2};
        param[1] = new int[]{2,3};
        param[2] = new int[]{3,4};
        param[3] = new int[]{1,4};
        param[4] = new int[]{1,5};
        int[] result = doTest(param);
        System.out.println(result);
    }

    public static int[] doTest(int[][] edges) {
        int nodesCount = edges.length;
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < nodesCount; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public static int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

}
