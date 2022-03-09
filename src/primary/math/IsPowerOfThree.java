package primary.math;

/**
 * @author taojie
 */
public class IsPowerOfThree {

    public static void main(String[] args) {
        boolean result = doTest(27);
        System.out.println(result);
    }

    public static boolean doTest(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
