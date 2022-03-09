package primary.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taojie
 */
public class CountPrimes {

    public static void main(String[] args) {
        int result = doTest(10);
        System.out.println(result);
    }

    public static int doTest(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int result = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j * j <= i; ++j) {
                if (i % j == 0) {
                    flag =  false;
                }
            }
            if (flag) {
                result++;
            }
        }
        return result;
    }

}
