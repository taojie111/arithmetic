package medium.math;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {

    public static void main(String[] args) {
        boolean result = doTest(2);
        System.out.println(result);
    }

    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public static boolean doTest(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

}
