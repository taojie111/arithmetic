package medium.math;

public class MyPow {

    public static void main(String[] args) {
        double result = myPow(2.00000,10);
        System.out.println(result);
    }

    public static double myPow(double x, int n) {
        long N = n;
        double rtn = 0;
        if (N >= 0) {
            rtn = quickMul(x, N);
        } else {
            rtn = 1.0 / quickMul(x, -N);
        }
        return rtn;
    }

    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
