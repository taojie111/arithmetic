package hot100;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        dfs(result, digits, 0, "");
        return result;
    }

    public static void dfs(List<String> result, String digits, int pos, String trace) {
        if (pos == digits.length()) {
            if (trace != null && trace.length() > 0) {
                result.add(trace);
            }
            return;
        }
        String letter = map.get(digits.charAt(pos));
        for (int i = 0; i < letter.length(); i++) {
            trace = trace + letter.charAt(i);
            dfs(result, digits, pos + 1, trace);
            trace = trace.substring(0, trace.length() - 1);
        }
    }
}
