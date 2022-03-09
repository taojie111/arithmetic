package primary.math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {
        List<String> result = doTest(5);
        System.out.println(result);
    }

    public static List<String> doTest(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String s = "";
            if (i % 3 == 0) {
                s = s + "Fizz";
            }
            if (i % 5 == 0) {
                s = s + "Buzz";
            }
            if (s.length() == 0) {
                s = s + i;
            }
            result.add(s);
        }
        return result;
    }
}
