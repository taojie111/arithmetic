package medium.numAndString;

import java.util.*;

/**
 * @author taojie
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] param = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = doTest(param);
        System.out.println(result);
    }

    public static List<List<String>> doTest(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
