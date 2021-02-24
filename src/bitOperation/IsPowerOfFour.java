package bitOperation;

// https://leetcode-cn.com/problems/power-of-four/
public class IsPowerOfFour {

    public static void main(String[] args) {
        int param = 16;
        boolean result = doIsPowerOfFour(param);
        System.out.println(result);
    }

    // 自己的解法
    public static boolean doIsPowerOfFour(int param) {
        return (param > 0) && ((param & (-param)) == param) && ((param & 0xaaaaaaaa) == 0);
    }
}
