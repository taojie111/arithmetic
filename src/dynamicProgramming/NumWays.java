package dynamicProgramming;

public class NumWays {

    public static void main(String[] args) {
        int[][] param = new int[7][2];
        param[0] = new int[]{0,2};
        param[1] = new int[]{2,1};
        param[2] = new int[]{3,4};
        param[3] = new int[]{2,3};
        param[4] = new int[]{1,4};
        param[5] = new int[]{2,0};
        param[6] = new int[]{0,4};
        int result = numWays(5, param, 3);
        System.out.println(result);
    }

    public static int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }

}
