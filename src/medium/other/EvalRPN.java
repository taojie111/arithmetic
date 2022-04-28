package medium.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EvalRPN {

    public static void main(String[] args) {
        String[] param = new String[]{"4","13","5","/","+"};
        int result = doTest(param);
        System.out.println(result);
    }

    public List<String> ops = new ArrayList<>();

    public static int doTest(String[] param) {
        List<String> ops = new ArrayList<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < param.length; i++) {
            String s = param[i];
            if (ops.contains(s)) {
                stack.push(calculate(stack, s));
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static int calculate(Stack<Integer> stack, String operator) {
        int num1 = stack.pop();
        int num2 = stack.pop();
        if ("+".equals(operator)) {
            return num2 + num1;
        } else if ("-".equals(operator)) {
            return num2 - num1;
        } else if ("*".equals(operator)) {
            return num2 * num1;
        } else if ("/".equals(operator)) {
            return num2 / num1;
        }
        return 0;
    }
}
