package hash;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
// 示例 1：输入：nums = [100,4,200,1,3,2],输出：4,解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
// 示例 2：输入：nums = [0,3,7,2,5,8,4,6,0,1],输出：9
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] param = new int[]{0,3,7,2,5,8,4,6,0,1};
        int result = doLongestConsecutive(param);
        System.out.println(result);
    }

    // 自己的解法
    public static int doLongestConsecutive(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i=0; i< arr.length; i++) {
            if (i==0) {
                count++;
                continue;
            }
            if (arr[i] == arr[i -1] + 1) {
                count++;
            } else if (arr[i] == arr[i -1]) {
                continue;
            } else {
                break;
            }
        }
        return count;
    }

    // 官方的解法
    public static int longestConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int longest = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int current = 1;
            int currentNum = num;
            while (set.contains(currentNum + 1)) {
                current += 1;
                currentNum += 1;
            }
            longest = Math.max(current,longest);
        }
        return longest;
    }
}
