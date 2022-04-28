package medium.other;

public class GetSum {

    public static void main(String[] args) {
        int result = doTest(1,2);
        System.out.println(result);
    }

    public static int doTest(int a, int b) {
        if ((a & b) == 0) {
            return a ^ b;
        }
        return doTest(a ^ b, (a & b) << 1);
    }
}
