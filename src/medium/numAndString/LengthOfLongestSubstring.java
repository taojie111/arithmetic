package medium.numAndString;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String param = " ";
        int result = doTest(param);
        System.out.println(result);
    }

    private static Map<Character, Integer> map = new HashMap<>();

    public static int doTest(String s) {
        int result = 0;
        int length = s.length();
        int left = 0;
        int right = 0;
        while (right < length) {
            char c = s.charAt(right);
            int count = map.getOrDefault(c,0);
            if (count == 0) {
                map.put(c,1);
            } else {
                result = Math.max(result, right - left);
                while (s.charAt(left) != c) {
                    map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0) - 1);
                    left++;
                }
                left++;
            }
            right++;
            result = Math.max(result, right - left);
        }
        return result;
    }
}
