package characterString;

// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
// 示例 1:输入: s = "anagram", t = "nagaram",输出: true
// 示例 2:输入: s = "rat", t = "car",输出: false

        import java.util.Arrays;
        import java.util.HashMap;
        import java.util.Map;

public class IsAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s, t);
    }

    // 自己的解法
    public static boolean doIsAnagram(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    // 官方解法
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] table = new int[26];
        for (int i=0; i<s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }

        for (int i=0; i<t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    // 时间复杂度为O(n)的解法
    public static boolean isAnagram2(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            map.put(c,map.getOrDefault(c,0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
}
