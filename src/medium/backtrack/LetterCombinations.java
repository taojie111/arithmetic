package medium.backtrack;

import com.sun.xml.internal.ws.util.StringUtils;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author taojie
 */
public class LetterCombinations {

    public static void main(String[] args) {
        List<String> result = doTest("236");
        System.out.println(result);
    }

    private static Map<Character, String> map = new HashMap<Character, String>(16) {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public static List<String> doTest(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        LinkedList<Character> trace = new LinkedList<>();
        dfs(result, digits, 0, trace);
        return result;
    }

    public static void dfs(List<String> result, String digits, int pos, LinkedList<Character> trace) {
        if (trace.size() == digits.length()) {
            result.add(getStr(trace));
            return;
        }
        String s1 = map.get(digits.charAt(pos));
        for (int j = 0; j < s1.length(); j++) {
            Character c = s1.charAt(j);
            trace.add(c);
            dfs(result, digits, pos + 1, trace);
            trace.removeLast();
        }
    }

    public static String getStr(LinkedList<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
