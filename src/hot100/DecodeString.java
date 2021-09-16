package hot100;

import java.io.IOException;
import java.util.Stack;

/**
 * @author taojie
 */
public class DecodeString {

    public static void main(String[] args) throws IOException {
        String result = decodeString("2[abc]3[cd]ef");
        System.out.println(result);
    }

    public static String doTest(String s) {
        int length = s.length();
        int ptr = 0;
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        while (ptr < length) {
            char c = s.charAt(ptr);
            if (Character.isDigit(c)) {
                numStack.push(Character.getNumericValue(c));
            } else {
                if (c != ']') {
                    strStack.push(Character.toString(c));
                } else {
                    String encodeStr = "";
                    while (true) {
                        String strElement = strStack.pop();
                        if (Character.toString('[').equals(strElement)) {
                            int numElement = numStack.pop();
                            String waitPush = "";
                            for (int i = 0; i < numElement; i++) {
                                waitPush = waitPush + encodeStr;
                            }
                            strStack.push(waitPush);
                            break;
                        } else {
                            encodeStr = strElement + encodeStr;
                        }
                    }
                }
            }
            ptr++;
        }
        String result = "";
        while (!strStack.isEmpty()) {
            result = strStack.pop() + result;
        }
        return result;
    }

    static String src;
    static int ptr;

    public static String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    public static String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            // String -> EPS
            return "";
        }

        char cur = src.charAt(ptr);
        int repTime = 1;
        String ret = "";

        if (Character.isDigit(cur)) {
            // String -> Digits [ String ] String
            // 解析 Digits
            repTime = getDigits();
            // 过滤左括号
            ++ptr;
            // 解析 String
            String str = getString();
            // 过滤右括号
            ++ptr;
            // 构造字符串
            while (repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            // String -> Char String
            // 解析 Char
            ret = String.valueOf(src.charAt(ptr++));
        }

        return ret + getString();
    }

    public static int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }

}
