package medium.numAndString;

public class LongestPalindrome {

    public static void main(String[] args) {
        String result = doTest("bbabad");
        System.out.println(result);
    }

    public static String doTest(String s) {
        int length = s.length();
        for (int i = length; i >= 0; i--) {
            int left = 0;
            int right = i;
            while (right <= length) {
                String subStr = s.substring(left, right);
                if (isPalindrome(subStr)) {
                    return subStr;
                }
                left++;
                right++;
            }
        }
        return null;
    }

    public static boolean isPalindrome(String subStr) {
        int length = subStr.length();
        if (length == 1) {
            return true;
        }
        if (length == 2) {
            return subStr.charAt(0) == subStr.charAt(1);
        }
        int mid = subStr.length() / 2;
        int left = 0;
        int right = 0;
        if (length % 2 == 0) {
            left = mid -1;
            right = mid;
        } else {
            left = mid - 1;
            right = mid + 1;
        }
        while (left >= 0 && right < length) {
            if (subStr.charAt(left) != subStr.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

}
