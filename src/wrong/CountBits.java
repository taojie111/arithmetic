package wrong;

public class CountBits {

    public static void main(String[] args) {
        int param = 2;
        int[] result = doTest(param);
        System.out.println(result);
    }

    public static int[] doTest(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int temp = i;
            while (temp != 0) {
                temp = temp & (temp - 1);
                count++;
            }
            result[i] = count;
        }
        return result;
    }

}
