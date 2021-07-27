package hot100;

public class SingleNumber {

    public static void main(String[] args) {
        int[] param = new int[]{4,1,2,1,2};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] param) {
        int result = 0;
        for (int i : param) {
            result ^= i;
        }
        return result;
    }
}
