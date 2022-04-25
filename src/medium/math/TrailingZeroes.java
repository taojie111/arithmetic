package medium.math;

public class TrailingZeroes {

    public static void main(String[] args) {
        int result = trailingZeroes(130);
        System.out.println(result);
    }

    public static int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
