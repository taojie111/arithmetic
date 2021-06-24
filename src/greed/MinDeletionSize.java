package greed;

public class MinDeletionSize {

    public static void main(String[] args) {
        String[] param = new String[]{"zyx","wvu","tsr"};
        int result = doTest(param);
        System.out.println(result);
    }

    // 贪心算法
    // 1、全局最优解：使用最小的代价把所有筹码移动到统一位置
    // 2、局部最优解：每次尽量移动2个单位，如果不能移动两个单位，才移动一个单位
    // 3、合并局部解
    public static int doTest(String[] param) {
        int result = 0;
        char[][] arr = new char[param.length][param[0].length()];
        for (int i = 0; i < param.length; i++) {
            for (int j = 0; j < param[i].length(); j++) {
                arr[i][j] = param[i].charAt(j);
            }
        }
        char pre = 0;
        for (int i = 0; i < param[0].length(); i++) {
            for (int j = 0; j < param.length; j++) {
                if (j == 0) {
                    pre =  arr[j][i];
                    continue;
                }
                if (arr[j][i] - pre < 0) {
                    result++;
                    break;
                }
                pre =  arr[j][i];
            }
        }
        return result;
    }

}
