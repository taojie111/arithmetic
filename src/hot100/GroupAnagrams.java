package hot100;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taojie
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] param = new String[]{""};
        List<List<String>> result = doTest(param);
        System.out.println(result);
    }

    public static List<List<String>> doTest(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>(10);
        for (String str : strs) {
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum = sum + str.charAt(i);
            }
            if (map.containsKey(sum)) {
                map.get(sum).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sum, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
