package dynamicProgramming;

/**
 * @author taojie
 */
public class ClimbStairs {

    public static void main(String[] args) {
        int result = climbStairs(3);
        System.out.println(result);
    }

    public static int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
