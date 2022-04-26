package medium.math;

public class MySqrt {

    public static void main(String[] args) {
        int result = mySqrt(2);
        System.out.println(result);
    }

    public static int mySqrt(int n) {
        int l = 0, r = n, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= n) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
