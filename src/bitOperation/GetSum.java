package bitOperation;

// https://leetcode-cn.com/problems/sum-of-two-integers/
public class GetSum {

    public static void main(String[] args) {
        int param1 = 222;
        int param2 = 333;
        int result = doGetSum(param1, param2);
        System.out.println(result);
    }

    // 官方解法
    public static int doGetSum(int param1, int param2) {
        if (param2 == 0) {
            return param1;
        }
        int result = doGetSum(param1 ^ param2, (param1 & param2) << 1);
        return result;
    }

}
