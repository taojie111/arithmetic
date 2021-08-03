package hot100;

import java.util.List;

public class HammingDistance {

    public static void main(String[] args) {
        int result = doTest(1, 4);
        System.out.println(result);
    }

    public static int doTest(int x, int y) {
        int result = 0;
        int z = x ^ y;
        while(z > 0) {
            z = z & (z - 1);
            result++;
        }
        return result;
    }
}
