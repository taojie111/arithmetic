package dynamicProgramming;

public class DivisorGame {

    public static void main(String[] args) {
        boolean result = divisorGame(5);
        System.out.println(result);
    }

    public static boolean divisorGame(int n) {
        boolean[] f = new boolean[n + 5];
        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }

}
