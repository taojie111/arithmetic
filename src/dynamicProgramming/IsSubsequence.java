package dynamicProgramming;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class IsSubsequence {

    public static void main(String[] args) {
        boolean result = doTest("abc", "ahbgdc");
        System.out.println(result);
    }

    // 动态规划
    public static boolean doTest(String s, String t) {
        // 删除0个字符
        // 删除0个：ahbgdc
        // 删除1个：hbgdc,abgdc,ahgdc,ahbdc,ahbgc,ahbgd
        // 删除2个：bgdc,hgdc,hbdc,hbgc,hbgd
        // 删除2个：bgdc,agdc,abdc,abgc,abgd
        // 删除2个：hgdc,agdc,ahdc,ahgc,ahgd
        // 删除2个：hbdc,abdc,ahdc,ahbc,ahbd
        // 删除2个：hbgc,abgc,ahgc,ahbc,ahbg
        // 删除2个：hbgd,abgd,ahgd,ahbd,ahbg
        String[][] dp = new String[t.length() - 1][];
        dp[0] = new String[1];
        dp[0][0] = t;
        for (int i = 1; i < t.length(); i++) {
            dp[i] = new String[dp[i - 1][0].length() * dp[i - 1].length / i];
            int index = 0;
            int length = dp[i - 1][0].length();
            for (int j = 0; j < dp[i - 1].length; j++) {
                int start = 0;
                if (j > 0) {
                    start = j % length;
                }
                for (int k = start; k < dp[i - 1][j].length(); k++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(dp[i - 1][j]);
                    dp[i][index++] = sb.delete(k, k+1).toString();
                }
            }
        }
        return true;
    }

}
