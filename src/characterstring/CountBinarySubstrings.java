package characterstring;

// 给定一个字符串 s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。重复出现的子串要计算它们出现的次数。
// 示例 1 :输入: "00110011",输出: 6,解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
// 示例 2 :输入: "10101",输出: 4,解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {

    public static void main(String[] args) {
        String param = "00111011";
        int result = doCountBinarySubstrings(param);
        System.out.println(result);
    }

    public static int doCountBinarySubstrings(String param) {
        int length = param.length();
        char[] arr = param.toCharArray();
        int result = 0;
        for (int i=0; i<arr.length; i++) {
            int num0 = 0;
            int num1 = 0;
            boolean flag;
            if (arr[i] == '0') {
                num0++;
                flag = true;
            } else {
                num1++;
                flag = false;
            }
            char temp = arr[i];
            int m = 0;
            for (int j = i+ 1; j<arr.length; j++) {
                if (num0 == num1) {
                    break;
                }
                if (temp == arr[j]) {
                   if (flag) {
                       num0++;
                   } else {
                       num1++;
                   }
                } else {
                    if (m == 1) {
                        break;
                    }
                    m++;
                    temp = arr[j];
                    if (flag) {
                        num1++;
                    } else {
                        num0++;
                    }
                    flag = !flag;
                }
            }
            if (num0 == num1) {
                result++;
            }
        }
        return result;
    }

    public static int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<Integer>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }
}
