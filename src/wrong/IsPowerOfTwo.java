package wrong;

public class IsPowerOfTwo {

    public static void main(String[] args) {
        boolean result = doTest2(16);
        System.out.println(result);
    }

    public static boolean doTest1(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        return process(n);
    }

    public static boolean process(int n) {
        if (n % 2 != 0) {
            return false;
        }
        if (n / 2 == 1) {
            return true;
        }
        return process(n / 2);
    }

    public static boolean doTest2(int n) {
        if (n <= 0) {
            return false;
        }
        if ((n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }
}
