package bitOperation;

// https://leetcode-cn.com/problems/binary-number-with-alternating-bits/description/
public class HasAlternatingBits {

    public static void main(String[] args) {
        int param = 42;
        boolean result = doHasAlternatingBits(param);
        System.out.println(result);
    }

    // 自己的解法
    public static boolean doHasAlternatingBits(int param) {
        return ((param & 0xaaaaaaaa) == 0) || ((param & 0x55555555) == 0);
    }

}
