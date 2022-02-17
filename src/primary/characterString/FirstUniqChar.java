package primary.characterString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taojie
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        int result = doTest("aabb");
        System.out.println(result);
    }

    public static int doTest(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
