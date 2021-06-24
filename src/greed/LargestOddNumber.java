package greed;

public class LargestOddNumber {

    public static void main(String[] args) {
        String result = doTest("35426");
        System.out.println(result);
    }

    // 贪心算法
    // 1、全局最优解：值最大的奇数
    // 2、局部最优解：每次得到的子字符串都是最大的数，每次去除最后一个字符
    // 3、合并局部解
    public static String doTest(String param) {
        String result = "";
        while (param.length() > 0) {
            if (isOdd(Integer.valueOf(param))) {
                return param;
            }
            param = param.substring(0, param.length() - 1);
        }
        return result;
    }

    private static boolean isOdd(int num) {
        if ((num & 1) == 1) {
            return true;
        }
        return false;
    }

}
