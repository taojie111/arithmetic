package unionFind;

public class MakeConnected {

    public static void main(String[] args) {
        int[][] param = new int[5][2];
        param[0] = new int[]{0,1};
        param[1] = new int[]{0,2};
        param[2] = new int[]{0,3};
        param[3] = new int[]{1,2};
        param[4] = new int[]{1,3};
        int result = doTest(6, param);
        System.out.println(result);
    }

    public static int doTest(int n, int[][] connections) {
        // 把带有环的图变成树（最小生成树）
        int result = 0;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < connections.length; i++) {
            int[] conn = connections[i];
            if (find(parent, conn[0]) != find(parent, conn[1])) {
                union(parent, conn[0], conn[1]);
            } else {
                result++;
            }
        }
        return result;
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
