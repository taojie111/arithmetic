package wrong;

public class SingleNumber3 {

    public static void main(String[] args) {
        int[] param = new int[]{1,2,1,3,2,5};
        int[] result = doTest(param);
        System.out.println(result);
    }

    public static int[] doTest(int[] param) {
        int num1 = 0;
        int num2 = 0;
        int[] result = new int[2];
        int temp = 0;
        for (int i = 0; i < param.length; i++) {
            int i1 = param[i];
            temp ^= i1;
        }
        int n = temp & (-temp);
        for (int i = 0; i < param.length; i++) {
            int i1 = param[i];
            if ((n & i1) == 0 ) {
                num1 ^= i1;
            } else {
                num2 ^= i1;
            }
        }
        result[0] = num1;
        result[1] = num2;
        return result;
    }
}
