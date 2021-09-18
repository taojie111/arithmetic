package hot100;

import java.util.*;

/**
 * @author taojie
 */
public class FindAnagrams {

    public static void main(String[] args) {
        List<Integer> result = doTest("cbaebabacd","abc");
        System.out.println(result);
    }

    private static Map<Character, Integer> ori = new HashMap<>();
    private static Map<Character, Integer> cnt = new HashMap<>();

    public static List<Integer> doTest(String s, String p) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            ori.put(p.charAt(i), ori.getOrDefault(p.charAt(i), 0) + 1);
        }
        int sLen = s.length();
        int l = 0;
        int r = -1;
        while (r < sLen - 1) {
            r++;
            char c = s.charAt(r);
            if (ori.containsKey(c)) {
                if (cnt.getOrDefault(c, 0) > 0) {
                    if (s.charAt(r - 1) == c) {
                        cnt.clear();
                        cnt.put(c, cnt.getOrDefault(c, 0) + 1);
                        l = r;
                    } else {
                        l++;
                    }
                } else {
                    cnt.put(c, cnt.getOrDefault(c, 0) + 1);
                }
            } else {
                l = r + 1;
                cnt.clear();
            }
            if (check()) {
                result.add(l);
                cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l),0) - 1);
                l++;
            }
        }
        return result;
    }

    private static boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
