package primary.characterString;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] param = new String[]{"flower","flow","flight"};
        String result = doTest(param);
        System.out.println(result);
    }

    public static String doTest(String[] strs) {
        String result = "";
        int length = strs.length;
        int minLength = Integer.MAX_VALUE;
        String s = null;
        for (int i = 0; i < length; i++) {
            String str = strs[i];
            minLength = Math.min(minLength, str.length());
        }
        for (int i = 0; i < minLength; i++) {
            for (int j = 0; j < length; j++) {
                String str = strs[j];
                if (j == 0) {
                    s = str.substring(i,i+1);
                } else {
                    if (!s.equals(str.substring(i,i+1))) {
                        return result;
                    }
                }
            }
            result = result + s;
        }
        return result;
    }
}
