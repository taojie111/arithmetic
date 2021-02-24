package bitOperation;

// https://leetcode-cn.com/problems/power-of-two/description/
public class IsPowerOfTwo {

    public static void main(String[] args) {
        int param = 1126;
        boolean result = doIsPowerOfTwo(param);
        System.out.println(result);
    }

    // 自己的解法
    public static boolean doIsPowerOfTwo(int param) {
        int temp = 0;
        for (int i=0;i<10000;i++) {
            if (i == 0) {
               temp = 1;
            } else if (i == 1) {
                temp = 2;
            } else {
                temp = 2 << i;
            }
            if (temp > param) {
                return false;
            }
            if (temp == param) {
                return true;
            }
        }
        return false;
    }

    // 官方解法1
    public static boolean isPowerOfTwo1(int param) {
        if (param == 0) {
            return false;
        }
        return (param & (-param)) == param;
    }
    // 官方解法2
    public static boolean isPowerOfTwo2(int param) {
        if (param == 0) {
            return false;
        }
        return (param & (param - 1)) == 0;
    }
}
