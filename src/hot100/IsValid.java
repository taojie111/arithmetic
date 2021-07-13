package hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author taojie
 */
public class IsValid {

    public static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("(",")");
        map.put("[","]");
        map.put("{","}");
        String param = "[{(){()}}[]]";
        boolean result = doTest(param);
        System.out.println(result);
    }

    public static boolean doTest(String param) {
        Stack<String> stack = new Stack<>();
        String[] arr = param.split("");
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                stack.push(arr[i]);
            } else {
                if (map.get(stack.peek()).equals(arr[i])) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

}
