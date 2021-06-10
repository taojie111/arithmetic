package divideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class OperatorPrecedence {

    public static void main(String[] args) {
        List<Integer> result = diffWaysToCompute("2*3-4*5");
        System.out.println(result);
    }

    public static List<Integer> diffWaysToCompute(String input) {
        if (input.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int num = 0;
        //考虑是全数字的情况
        int index = 0;
        while (index < input.length() && !isOperation(input.charAt(index))) {
            num = num * 10 + input.charAt(index) - '0';
            index++;
        }
        //将全数字的情况直接返回
        if (index == input.length()) {
            result.add(num);
            return result;
        }

        for (int i = 0; i < input.length(); i++) {
            //通过运算符将字符串分成两部分
            if (isOperation(input.charAt(i))) {
                List<Integer> result1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> result2 = diffWaysToCompute(input.substring(i + 1));
                //将两个结果依次运算
                for (int j = 0; j < result1.size(); j++) {
                    for (int k = 0; k < result2.size(); k++) {
                        char op = input.charAt(i);
                        result.add(caculate(result1.get(j), op, result2.get(k)));
                    }
                }
            }
        }
        return result;
    }

    private static int caculate(int num1, char c, int num2) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }

    private static boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }

}
