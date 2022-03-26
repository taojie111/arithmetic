package characterString;

// 给你一个整数 x ，如果 x 是一个回文整数，返回 ture ；否则，返回 false 。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
// 示例 1：输入：x = 121,输出：true
// 示例 2：输入：x = -121,输出：false,解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 示例 3：输入：x = 10,输出：false,解释：从右向左读, 为 01 。因此它不是一个回文数。
// 示例 4：输入：x = -101,输出：false
public class IsPalindrome {

    public static void main(String[] args) {
        int param = 11;
        boolean result = doIsPalindrome(param);
        System.out.println(result);
    }

    // 自己的解法
    public static boolean doIsPalindrome(int param) {
        String temp = param + "";
        StringBuffer sb = new StringBuffer (temp);
        sb.reverse();
        if (temp.equals(sb.toString())) {
            return true;
        }
        return false;
    }


    // 官方的解法
    public static boolean isPalindrome(int param) {
        int revertedNumber = 0;
        while (param > revertedNumber) {
            revertedNumber = revertedNumber*10 + param%10;
            param /= 10;
        }
        return param == revertedNumber || revertedNumber/10 == param;
    }
}
