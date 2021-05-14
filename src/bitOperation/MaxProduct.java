package bitOperation;

public class MaxProduct {

    public static void main(String[] args) {
        String[] param = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        int result = maxProduct(param);
        System.out.println(result);
    }

    public static int maxProduct(String[] param) {
        int n = param.length;
        int maxProd = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (noCommonLetters(param[i], param[j])) {
                    maxProd = Math.max(maxProd, param[i].length() * param[j].length());
                }
            }
        }
        return maxProd;
    }

    public static boolean noCommonLetters(String s1, String s2) {
        int bitmask1 = 0, bitmask2 = 0;
        for (char ch : s1.toCharArray()) {
            bitmask1 |= 1 << bitNumber(ch);
        }
        for (char ch : s2.toCharArray()) {
            bitmask2 |= 1 << bitNumber(ch);
        }

        return (bitmask1 & bitmask2) == 0;
    }

    public static int bitNumber(char ch) {
        return (int)ch - (int)'a';
    }

}
