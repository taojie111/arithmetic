package medium.other;

import java.util.*;

/**
 * @author taojie
 */
public class LeastInterval {

    public static void main(String[] args) {
        // 'A','A','A','A','A','A','B','C','D','E','F','G'
        char[] param = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int result = leastInterval2(param, 2);
        System.out.println(result);
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // 任务总数
        int m = freq.size();
        List<Integer> nextValid = new ArrayList<Integer>();
        List<Integer> rest = new ArrayList<Integer>();
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            nextValid.add(1);
            rest.add(value);
        }

        int time = 0;
        for (int i = 0; i < tasks.length; ++i) {
            ++time;
            int minNextValid = Integer.MAX_VALUE;
            for (int j = 0; j < m; ++j) {
                if (rest.get(j) != 0) {
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }
            time = Math.max(time, minNextValid);
            int best = -1;
            for (int j = 0; j < m; ++j) {
                if (rest.get(j) != 0 && nextValid.get(j) <= time) {
                    if (best == -1 || rest.get(j) > rest.get(best)) {
                        best = j;
                    }
                }
            }
            nextValid.set(best, time + n + 1);
            rest.set(best, rest.get(best) - 1);
        }

        return time;
    }

    public static int leastInterval2(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        // 最多的执行次数
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }

        // 具有最多执行次数的任务数量
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                ++maxCount;
            }
        }

        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }

}
