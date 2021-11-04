package hot100;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String param = "pwwkew";
        int result = doTest(param);
        System.out.println(result);
    }

    private static Map<Character, Integer> map = new HashMap<>();

    public static int doTest(String s) {
        int max = 0;
        int length = s.length();
        int left = 0;
        int right = 0;
        while (right < length) {
            if (!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), right);
            } else {
                max = Math.max(max, right - left);
                left = map.get(s.charAt(right)) + 1;
                map.put(s.charAt(right), right);
            }
            right++;
        }
        return max;
    }
}
