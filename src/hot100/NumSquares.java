package hot100;

/**
 * @author taojie
 *
 * 给定正整数n，找到若干个完全平方数（比如1,4,9,16, ...）使得它们的和等于n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数n，返回和为 n 的完全平方数的最少数量。
 * 完全平方数是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9和16都是完全平方数，而3和11不是。
 *
 * 示例1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 *
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 */
public class NumSquares {

    public static void main(String[] args) {
        int result = numSquares(12);
        System.out.println(result);
    }

    public static int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}
