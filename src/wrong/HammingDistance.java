package wrong;

public class HammingDistance {

    public static void main(String[] args) {
        int result = doTest(1, 4);
        System.out.println(result);
    }

    public static int doTest(int x, int y) {
        int result = 0;
        int i = x ^ y;
        while (i > 0) {
            i = i & (i -1);
            result++;
        }
        return result;
    }
}
