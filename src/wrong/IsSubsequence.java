package wrong;

public class IsSubsequence {

    public static void main(String[] args) {
        boolean result = doTest("abc", "ahbbgbdc");
        System.out.println(result);
    }

    // base case、状态、选择、状态转移方程
    // base case: f[t.length()][i] = m;
    // 状态：t的每个字符，26个字母
    // 选择：循环t的每个字符，循环26个字母
    public static boolean doTest(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

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
