package hot100;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abcccccccdd";
        int result = doLongestPalindrome(s);
        System.out.println(result);
    }

    // 自己的解法
    public static int doLongestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int sum = 0;
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            sum += entry.getValue() / 2 * 2;
            if (map.get(ch) % 2 != 0) {
                flag = true;
            }
        }
        if (flag) {
            sum += 1;
        }
        return sum;
    }
}
