package divideAndConquer;

public class ReverseBits {

    public static void main(String[] args) {
        int result = doTest(10101);
        System.out.println(result);
    }

    public static int doTest(int n) {
        return divideAndConquer(n, 0, getHighIndex(n));
    }

    public static int divideAndConquer(int n, int l, int h) {
        if (isOne(n)) {
            return n;
        }
        int mid = (h - l) / 2 + l;
        int leftBits = getBits(n, 0, mid);
        int rightBits = getBits(n, mid + 1, h);
        int left = divideAndConquer(leftBits, 0, mid);
        int right = divideAndConquer(rightBits, mid + 1, h);
        return conquer(left, right);
    }

    private static int getBits(int n, int start, int end) {
        String s = String.valueOf(n);
        s.substring(start, end);
        return Integer.valueOf(s.substring(start, end + 1));
    }

    private static int getHighIndex(int n) {
        String s = String.valueOf(n);
        return s.length() - 1;
    }

    private static boolean isOne(int n) {
        String s = String.valueOf(n);
        if (s.length() == 1) {
            return true;
        }
        return false;
    }

    private static int conquer(int left, int right) {
        String sLeft = String.valueOf(left);
        String sRight = String.valueOf(right);
        String result = sRight + sLeft;
        return Integer.valueOf(result);
    }

}
