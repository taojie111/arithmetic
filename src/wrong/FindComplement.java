package wrong;

public class FindComplement {

    public static void main(String[] args) {
        int result = doTest(5);
        System.out.println(result);
    }

    public static int doTest(int num) {
        int temp = num;
        while (true) {
            if ((temp & (temp - 1)) == 0) {
                break;
            }
            temp = temp & (temp - 1);
        }
        int index = -1;
        while (temp != 0) {
            temp = temp >> 1;
            index++;
        }
        int mask = 1;
        for (int i = 0; i <= index; i++) {
            mask = 2 * mask;
        }
        mask = mask - 1;
        return num ^ mask;
    }

}
