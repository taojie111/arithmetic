package greed;

import java.util.Arrays;

public class LargestSumAfterKNegations {

    public static void main(String[] args) {
        int[] param = new int[]{3,1,0,2};
        int result = doTest(param, 3);
        System.out.println(result);
    }

    // 贪心算法
    // 1、全局最优解：经过K次替换后，数组和尽可能最大
    // 2、局部最优解：每次都替换最小的数
    // 3、合并局部解
    public static int doTest(int[] param, int k) {
        int result = 0;
        for (int i = 1; i <= k; i++) {
            Arrays.sort(param);
            param[0] = -param[0];
        }
        for (int i = 0; i < param.length; i++) {
            result += param[i];
        }
        return result;
    }
}
