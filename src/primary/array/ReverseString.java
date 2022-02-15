package primary.array;

/**
 * @author taojie
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] param = new char[]{'1','2','3','4','5'};
        doTest(param);
    }

    public static void doTest(char[] s) {
        int length = s.length;
        int mid = length / 2;
        int left = 0;
        int right = 0;
        if (length % 2 == 0) {
            left = mid - 1;
            right = mid;
        } else {
            left = right = mid;
        }
        while (left >= 0 && right < length) {
            swap(s, left, right);
            left--;
            right++;
        }
        System.out.println(s);
    }

    private static void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
