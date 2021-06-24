package greed;

public class MinCostToMoveChips {

    public static void main(String[] args) {
        int[] param = new int[]{1,2,3,4};
        int result = doTest(param);
        System.out.println(result);
    }

    // 贪心算法
    // 1、全局最优解：使用最小的代价把所有筹码移动到统一位置
    // 2、局部最优解：每次尽量移动2个单位，如果不能移动两个单位，才移动一个单位
    // 3、合并局部解
    public static int doTest(int[] param) {
        int result = 0;
        return result;
    }

}
