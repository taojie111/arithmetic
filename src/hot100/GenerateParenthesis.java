package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author taojie
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        List<List<String>> result = doTest(6);
        List<String> test = new ArrayList<>();
        for (List<String> list : result) {
            String tmp = "";
            for (String s : list) {
                tmp = tmp + s;
            }
            System.out.println(tmp);
            if (!test.contains(tmp)) {
                test.add(tmp);
            }
        }
        System.out.println(test.size());
    }

    static List<List<String>> result = new ArrayList<>();

    static LinkedList<String> element = new LinkedList<>();

    public static List<List<String>> doTest(int n) {
        dfs(n);
        return result;
    }

    public static int leftCount = 0;

    public static int rightCount = 0;

    public static String preStr = ")";

    public static void dfs(int n) {
        int count = n << 1;
        if (count == element.size()) {
            result.add(new LinkedList<>(element));
            return;
        }
        for (int i = 1; i <= 2; i++) {
            if (leftCount == rightCount) {
                element.add("(");
                leftCount++;
                i++;
            } else if (leftCount > rightCount) {
                if (leftCount == n) {
                    element.add(")");
                    rightCount++;
                    i++;
                } else {
                    if ("(".equals(preStr)) {
                        element.add(")");
                        rightCount++;
                        preStr = ")";
                    } else if (")".equals(preStr)) {
                        element.add("(");
                        leftCount++;
                        preStr = "(";
                    }
                }
            }
            dfs(n);
            if (element.removeLast().equals("(")) {
                leftCount--;
            } else {
                rightCount--;
            }
        }
    }
}
