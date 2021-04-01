package bitOperation;

public class GetSum {

    public static void main(String[] args) {
        int param1 = 5;
        int param2 = 7;
        int result = doGetSum(param1, param2);
        System.out.println(result);
    }

    public static int doGetSum(int param1, int param2) {
        while (param2 != 0) {
            int temp = param1 ^ param2;
            param2 = (param1 & param2) << 1;
            param1 = temp;
        }
        return param1;
    }

}
