package hot100;

import java.io.IOException;

/**
 * @author taojie
 */
public class DecodeString {

    public static void main(String[] args) throws IOException {
        String result = doTest("abc3[cd]xyz");
        System.out.println(result);
    }

    public static String doTest(String s) {
        // pA + 2, pB
        int pA = 0;
        int pB = 0;
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        while (pA < length) {
            char c = s.charAt(pA);
            if (Character.isDigit(c)) {
                pB = pA;
                int count = 0;
                while (true) {
                    if (s.charAt(pB) == ']') {
                        break;
                    }
                    pB++;
                }
                String replaceS= s.substring(pA + 2, pB);
                for (int i = 1; i <= c - '0'; i++) {
                    sb.append(replaceS);
                }
                pA = pB + 1;
            } else {
                sb.append(c);
                pA++;
            }
        }
        return sb.toString();
    }


}
