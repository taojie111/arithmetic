package characterString;

import java.util.HashMap;
import java.util.Map;

// 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
// 示例 1:输入"abccccdd",输出,7。解释:我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abcccccccdd";
        int result = doLongestPalindrome(s);
        System.out.println(result);
    }

    // 自己的解法
    public static int doLongestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        int sum = 0;
        boolean flag = false;
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            sum += entry.getValue()/2*2;
            if (map.get(ch) % 2 != 0) {
                flag = true;
        }
        }
        if (flag) {
            sum += 1;
        }
        return sum;
    }
}
