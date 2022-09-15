package wrong;

public class NumTrees {
    public static void main(String[] args) {
        int result = doTest(3);
        System.out.println(result);
    }

    public static int doTest(int n) {
        return process(n);
    }

    public static int process(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int ans = 0;
        for (int j = 1; j <= n; ++j) {
            ans += process(j - 1) * process(n - j);
        }
        return ans;
    }

}
