package primary.characterString;

public class CountAndSay {

    public static void main(String[] args) {
        String result = doTest(7);
        System.out.println(result);
    }

    public static String doTest(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String pre = doTest(n - 1);
        return parse(pre);
    }

    public static String parse(String str) {
        String result = "";
        int count = 0;
        String value = null;
        String pre = null;
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i,i+1);
            if (i == 0) {
                pre = s;
                count++;
                value = s;
            } else {
                if (s.equals(pre)) {
                    count++;
                } else {
                    result = result + count + value;
                    pre = s;
                    value = s;
                    count = 1;
                }
            }
        }
        result = result + count + value;
        return result;
    }
}
