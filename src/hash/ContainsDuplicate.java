package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 给定一个整数数组，判断是否存在重复元素。如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
// 示例 1:输入: [1,2,3,1],输出: true
// 示例 2:输入: [1,2,3,4],输出: false
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] param = new int[]{1,1,1,3,3,4,3,2,4,2};
        boolean result = doContainsDuplicate(param);
        System.out.println(result);
    }

    public static boolean doContainsDuplicate(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int length = arr.length;
        for (int i=0; i<length; i++) {
            if (map.containsKey(arr[i])) {
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }
}
