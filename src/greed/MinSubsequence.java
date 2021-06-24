package greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence {
    public static void main(String[] args) {
        int[] param = new int[]{4,4,7,6,7};
        List<Integer> result = doTest(param);
        System.out.println(result);
    }

    // 贪心算法
    // 1、全局最优解：子序列和大于其他数的和的条件下，优先满足子序列长度最小，其次满足子序列和最大
    // 2、局部最优解：每次取出最大的两个数相加
    // 3、合并局部解
    public static List<Integer> doTest(int[] param) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(param);
        int sum = Arrays.stream(param).sum();
        int subSum = 0;
        for (int i = param.length - 1; i >= 0; i--) {
            subSum += param[i];
            if (subSum > sum - subSum) {
                result.add(param[i]);
                return result;
            } else {
                result.add(param[i]);
            }
        }
        return null;
    }
}