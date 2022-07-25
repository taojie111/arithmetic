package wrong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taojie
 */
public class PartitionLabels {

    public static void main(String[] args) {
        String param = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(param);
        System.out.println(result);
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Integer> startIndex = new HashMap<>();
        char[] cArr = s.toCharArray();
        int current = -1;
        int count = 0;
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            if (map.get(c) == null) {
                current++;
                map.put(c, i);
                startIndex.put(current, i);
                result.add(current, 1);
            } else {
                int currentStart = startIndex.get(current);
                int preStart = map.get(c);
                if (preStart == currentStart) {
                    result.set(current, result.get(current) + 1);
                } else if (preStart < currentStart) {
                    int section = getSection(startIndex, preStart);
                    if (section < current) {
                        for (int j = section + 1; j <= current; j++) {
                            result.remove(j);
                        }
                        current = section;
                        result.set(current, i - preStart + 1);
                    }
                } else {
                    result.set(current, result.get(current) + 1);
                }
            }
        }
        return result;
    }

    private static int getSection(Map<Integer, Integer> startIndex, int index) {
        for (Map.Entry<Integer, Integer> entry : startIndex.entrySet()) {
            if (entry.getValue() == index) {
                return entry.getKey();
            }
        }
        return -1;
    }

}
