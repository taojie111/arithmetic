package divideAndConquer;

public class ReverseBits {

    public static void main(String[] args) {
        String result = doTest("11111111111111111111111111111101");
        System.out.println(result);
    }

    public static String doTest(String n) {
        return divideAndConquer(n, 0, getHighIndex(n));
    }

    public static String divideAndConquer(String n, int l, int h) {
        if (isOne(n,l,h)) {
            return n.substring(l, h+1);
        }
        int mid = (h - l) / 2 + l;
        String left = divideAndConquer(n, l, mid);
        String right = divideAndConquer(n, mid + 1, h);
        return conquer(left, right);
    }

    private static String getBits(String n, int start, int end) {
        return n.substring(start, end + 1);
    }

    private static int getHighIndex(String n) {
        return n.length() - 1;
    }

    private static boolean isOne(String n, int l, int h) {
        if (n.substring(l, h+1).length() == 1) {
            return true;
        }
        return false;
    }

    private static String conquer(String left, String right) {
        return right + left;
    }

}
