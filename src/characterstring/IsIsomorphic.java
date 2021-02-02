package characterstring;

import java.util.HashMap;
import java.util.Map;

// 给定两个字符串 s 和 t，判断它们是否是同构的。如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
// 示例 1:输入：s = "egg", t = "add",输出：true
// 示例 2：输入：s = "foo", t = "bar",输出：true
// 示例 3：输入：s = "paper", t = "title",输出：true
public class IsIsomorphic {

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        boolean result = isIsomorphic(s,t);
        System.out.println(result);
    }

    // 自己的解法
    public static boolean doIsIsomorphic(String s, String t) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map1.put(c,map1.getOrDefault(c,0) + 1);
        }
        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            map2.put(c,map2.getOrDefault(c,0) + 1);
        }
        if (map1.size() != map2.size()) {
            return false;
        }
        map1.clear();
        map2.clear();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map1.put(c,map1.getOrDefault(c,0) + i);
        }
        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            map2.put(c,map2.getOrDefault(c,0) + i);
        }
        for (Map.Entry entry : map1.entrySet()) {
            if (!map2.containsValue(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    // 官方解法
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

    public static boolean isIsomorphicWithOther(String s, String t) {
        int sm[] = new int[128];
        int tm[] = new int[128];
        char sc[] = s.toCharArray();
        char tc[] = t.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(sm[sc[i]] != tm[tc[i]]) {
                return false;
            }
            sm[sc[i]] = tm[tc[i]] = i+1;
        }
        return true;
    }
}
