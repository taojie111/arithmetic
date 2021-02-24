package bitOperation;

import java.util.HashMap;
import java.util.Map;

// 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
// 示例 1：输入：nums = [1,2,1,3,2,5],输出：[3,5],解释：[5, 3] 也是有效的答案。
// 示例 2：输入：nums = [-1,0],输出：[-1,0]
public class SingleNumberTwo {

    public static void main(String[] args) {
        int[] param = new int[]{1,1,2,8};
        int[] result = singleNumberTwo(param);
        System.out.println(result);
    }

    // 自己的解法
    public static int[] doSingleNumberTwo(int[] param) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < param.length; i++) {
            map.put(param[i],map.getOrDefault(param[i],0) + 1);
        }
        String a = "";
        for (Integer key :map.keySet()) {
            if (map.get(key) == 1) {
                a = a + key.toString() + ",";
            }
        }
        String[] arr = a.split(",");
        for (int i = 0; i < arr.length; i++) {
            result[i] = Integer.parseInt(arr[i]);
        }
        return result;
    }

    // 官方解法
    public static int[] singleNumberTwo(int[] param) {
        int ret = 0;
        for (int n : param) {
            ret ^= n;
        }
        int div = 1;
        // 找到ret第一个为1的位置
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : param) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

}
