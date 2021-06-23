package greed;

import java.util.List;

/**
 * @author taojie
 */
public class BalancedStringSplit {

    public static void main(String[] args) {
        String param = "RRRLLRLL";
        int result = doTest(param);
        System.out.println(result);
    }

    // 贪心算法
    // 1、全局最优解：分割成尽可能多的平衡字符串
    // 2、局部最优解：每个平衡字符串包含字符尽可能的少
    // 3、合并局部解
    public static int doTest(String s) {
        int result = 0;
        int numL = 0;
        int numR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                numL++;
            }
            if (s.charAt(i) == 'R') {
                numR++;
            }
            if (numL > 0 && numL == numR) {
                result++;
            }
        }
        return result;
    }

}
