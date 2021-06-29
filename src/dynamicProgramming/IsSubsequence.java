package dynamicProgramming;

public class IsSubsequence {

    public static void main(String[] args) {
        boolean result = isSubsequence("abc", "ahbgdc");
        System.out.println(result);
    }

    // 动态规划
    // 把每种可能的子序列都列出来，如果字符串太长，性能低下，不可取
    public static boolean doTest(String s, String t) {
        /*
        删除0个：ahbgdc
        删除0个：dp[0][0]

        删除1个：hbgdc,abgdc,ahgdc,ahbdc,ahbgc,ahbgd
        删除1个：dp[0][0].delete1,dp[0][0].delete2,dp[0][0].delete3,dp[0][0].delete4,dp[0][0].delete5,dp[0][0].delete6

        删除2个：bgdc,hgdc,hbdc,hbgc,hbgd
        删除2个：agdc,abdc,abgc,abgd
        删除2个：ahdc,ahgc,ahgd
        删除2个：ahbc,ahbd
        删除2个：ahbg
        删除2个：dp[1][0].delete1,dp[1][0].delete2,dp[1][0].delete3,dp[1][0].delete4,dp[1][0].delete5
        删除2个：dp[1][1].delete2,dp[1][1].delete3,dp[1][1].delete4,dp[1][1].delete5
        删除2个：dp[1][2].delete3,dp[1][2].delete4,dp[1][2].delete5
        删除2个：dp[1][3].delete4,dp[1][3].delete5
        删除2个：dp[1][4].delete5

        删除3个：gdc,bdc,bgc,bgd,gdc,hdc,hgc,hgd,bdc,hdc,hbc,hbd,bgc,hgc,hbc,hbg,bgd,hgd,hbd,hbg
        删除3个：gdc,adc,agc,agd,bdc,adc,abc,abd,bgc,agc,abc,abg,bgd,agd,abd,abg
        删除3个：hdc,adc,ahc,ahd,hgc,agc,ahc,ahg,hgd,agd,ahd,ahg
        删除3个：hbc,abc,ahc,ahb,hbd,abd,ahd,ahb
        删除3个：hbg,abg,ahg,ahb
        删除3个：dp[1][0].delete1,dp[1][0].delete2,dp[1][0].delete3,dp[1][0].delete4,dp[1][0].delete5
        删除3个：dp[1][1].delete2,dp[1][1].delete3,dp[1][1].delete4,dp[1][1].delete5
        删除3个：dp[1][2].delete3,dp[1][2].delete4,dp[1][2].delete5
        删除3个：dp[1][3].delete4,dp[1][3].delete5
        删除3个：dp[1][4].delete5
        */
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

    // s = "abc", t = "ahbgdc"
    public static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        // f[i][j]表示字符串t中从位置i开始往后字符j第一次出现的位置
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

}
