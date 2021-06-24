package greed;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnits {

    public static void main(String[] args) {
        int[][] param = new int[4][2];
        param[0] = new int[]{5,10};
        param[1] = new int[]{2,5};
        param[2] = new int[]{4,7};
        param[3] = new int[]{3,9};
        int result = doTest(param, 10);
        System.out.println(result);
    }

    // 贪心算法
    // 1、全局最优解：装载尽可能多的单元数
    // 2、局部最优解：每次优先装载单元数最多的箱子类型
    // 3、合并局部解
    public static int doTest(int[][] param, int truckSize) {
        int result = 0;
        Arrays.sort(param, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval2[1] - interval1[1];
            }
        });
        for (int i = 0; i < param.length; i++) {
            if (truckSize - param[i][0] > 0) {
                result += param[i][0] * param[i][1];
            } else {
                result += truckSize * param[i][1];
                return result;
            }
            truckSize -= param[i][0];
        }
        return result;
    }

}