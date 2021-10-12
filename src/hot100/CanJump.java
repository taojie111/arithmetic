package hot100;

public class CanJump {

    public static void main(String[] args) {
        int[] param = new int[]{3,2,1,0,4};
        boolean result = doTest(param);
        System.out.println(result);
    }

    public static boolean doTest(int[] param) {
        int max = param.length - 1;
        boolean[] dp = new boolean[param.length];
        dp[0] = true;
        for (int i = 1; i < param.length; i++) {
            for (int j = 0; j < i; j++) {
                int jump = i - j;
                if (param[j] >= jump) {
                    dp[i] = true;
                    break;
                } else {
                    continue;
                }
            }

        }
        return dp[param.length - 1];
    }
}
