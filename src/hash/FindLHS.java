package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
// 示例 1:输入: [1,3,2,2,5,2,3,7]，输出: 5，原因: 最长的和谐数组是：[3,2,2,2,3].
public class FindLHS {

    public static void main(String[] args) {
        int[] param = new int[]{1,1,1,3,3,4,3,2,4,2,2};
        int result = findLHS(param);
        System.out.println(result);
    }

    // 自己的解法
    public static int doFindLHS(int[] arr) {
        int length = arr.length;
        int[] temp = new int[10];
        Map<String,Map<Integer,Integer>> map2 = new HashMap<>();
        for (int i=0; i<length; i++) {
            Map<Integer,Integer> map = new HashMap<>();
            map.getOrDefault(1,0);
            map.put(i, arr[i]);
            for (int j=i+1; j<length; j++) {
                boolean flag = true;
                for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                    int value = arr[j] - entry.getValue();
                    if (value < -1 || value > 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    map.put(j, arr[j]);
                }
            }
            temp[i] = map.size();
            map2.put(map.size() + "-" + i,map);
        }
        Arrays.sort(temp);
        return temp[temp.length - 1];
    }

    // 官方解法
    public static int findLHS(int[] arr) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                result = Math.max(result, map.get(key) + map.get(key + 1));
            }
        }
        return result;
    }
}
