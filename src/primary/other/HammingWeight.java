package primary.other;

public class HammingWeight {

    public static void main(String[] args) {
        int result = doTest(-3);
        System.out.println(result);
    }

    public static int doTest(int n) {
        int result = 0;
        while (n != 0) {
            n = n ^ (n & (-n));
            result++;
        }
        return result;
    }

}
