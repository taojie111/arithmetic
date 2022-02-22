package primary.characterString;

public class StrStr {

    public static void main(String[] args) {
        int result = strStr("BBABCDAB ABCDABCDABDE", "ABCDABD");
        System.out.println(result);
    }

    public static int strStr(String haystack, String needle) {
        Kmp kmp = new Kmp(needle);
        return kmp.searchKmp(haystack);
    }
}

class Kmp {

    public int[][] next;

    public String pattern;

    public Kmp(String pattern) {
        this.pattern = pattern;
        int x = 0;
        int length = pattern.length();
        next = new int[length][256];
        next[0][pattern.charAt(0)] = 1;
        for (int j = 1; j < length; j++) {
            for (int c = 0; c < 256; c++) {
                if (pattern.charAt(j) == c) {
                    next[j][c] = j + 1;
                } else {
                    next[j][c] = next[x][c];
                }
            }
            x = next[x][pattern.charAt(j)];
        }
    }

    public int searchKmp(String txt) {
        int length = txt.length();
        int j = 0;
        for (int i = 0; i < length; i++) {
            j = next[j][txt.charAt(i)];
            if (j == pattern.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
}
