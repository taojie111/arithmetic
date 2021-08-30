package slidingWindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CheckInclusion {

    public static void main(String[] args) {
        boolean result = doTest("aba", "eidaasbakabnaooo");
        System.out.println(result);
    }

    private static Map<Character, Integer> map1 = new HashMap<>();

    private static Map<Character, Integer> map2 = new HashMap<>();

    public static boolean doTest(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int l = 0;
        int r = -1;
        int length = s2.length();
        while (r < length) {
            r++;
            if (r < length && map1.containsKey(s2.charAt(r))) {
                map2.put(s2.charAt(r), map2.getOrDefault(s2.charAt(r), 0) + 1);
            } else {
              if (!map2.isEmpty()) {
                  map2.clear();
              }
              l++;
            }
            if (check()) {
                return true;
            }
        }
        return false;
    }

    public static boolean check() {
        Iterator iter = map1.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (!val.equals(map2.getOrDefault(key, 0))) {
                return false;
            }
        }
        return true;
    }
}
