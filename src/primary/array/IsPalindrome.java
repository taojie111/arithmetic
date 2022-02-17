package primary.array;

public class IsPalindrome {

    public static void main(String[] args) {
        boolean result = doTest("A man, a plan, a canal: Panama");
        System.out.println(result);
    }

    public static boolean doTest(String s) {
        String transformStr = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                transformStr = transformStr + Character.toLowerCase(s.charAt(i));
            }
        }
        int length = transformStr.length();
        int left = 0;
        int right = 0;
        int mid = length / 2;
        if (length % 2 == 0) {
            left = mid - 1;
            right = mid;
        } else {
            left = mid - 1;
            right = mid + 1;
        }
        while (left >= 0 && right < length) {
            if (transformStr.charAt(left) != transformStr.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
