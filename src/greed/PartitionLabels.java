package greed;

import java.util.ArrayList;
import java.util.List;

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
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
            for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

}
