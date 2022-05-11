package wrong;

public class IsPowerOfFour {

    public static void main(String[] args) {
        int param = 16;
        boolean result = doTest(param);
        System.out.println(result);
    }

    public static boolean doTest(int n) {
        if (n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0) {
            return true;
        }
        return false;
    }

}
