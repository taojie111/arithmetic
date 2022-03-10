package primary.other;

public class HammingDistance {

    public static void main(String[] args) {
        int result = doTest(1, 4);
        System.out.println(result);
    }

    public static int doTest(int x, int y) {
        int result = 0;
        int n = x ^ y;
        while (n != 0) {
            n = n ^ (n & (-n));
            result++;
        }
        return result;
    }

}
