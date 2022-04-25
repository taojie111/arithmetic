package medium.math;

public class TitleToNumber {

    public static void main(String[] args) {
        int result = doTest("AC");
        System.out.println(result);
    }

    public static int doTest(String columnTitle) {
        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }
}
