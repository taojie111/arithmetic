package primary.array;

public class Reverse {

    public static void main(String[] args) {
        int result = doTest(-123);
        System.out.println(result);
    }

    public static int doTest(int x) {
        String s = String.valueOf(x);
        int index = s.length() - 1;
        int result = 0;
        while (index >= 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            if ("-".equals(s.substring(index, index+1))) {
                result = -result;
            } else {
                result = 10 * result + Integer.parseInt(s.substring(index, index + 1));
            }
            index--;
        }
        return result;
    }
}
