package bitOperation;

import java.util.HashMap;
import java.util.Map;

public class MaxProduct {

    public static void main(String[] args) {
        String[] param = new String[]{"ab","abaa","abcw","baz","foo","bar","xtfn","abcdef"};
        int result = maxProduct2(param);
        System.out.println(result);
    }

    public static int doMaxProduct(String[] param) {
        int tempResult = 0;
        for (int i=0;i<param.length;i++) {
            for (int j=i+1;j<param.length;j++) {
                if (!doCompare2(param[i], param[j])) {
                    continue;
                }
                int temp =  param[i].length() * param[j].length();
                tempResult = Math.max(tempResult, temp);
            }
        }
        return tempResult;
    }

    // 自己的解法
    private static boolean doCompare1(String s1, String s2) {
        for (char ch : s1.toCharArray()) {
            if (s2.indexOf(ch) != -1) {
                return false;
            }
        }
        return true;
    }

    // 官方解法,时间复杂度为O(n)
    private static boolean doCompare2(String s1, String s2) {
        int bitmask1 = 0, bitmask2 = 0;
        for (char ch : s1.toCharArray()) {
            bitmask1 |= 1<<bitNumber(ch);
        }
        for (char ch : s2.toCharArray()) {
            bitmask2 |= 1<<bitNumber(ch);
        }
        return (bitmask1 & bitmask2) == 0;
    }

    // 官方解法,时间复杂度为O(n^2)
    private static int maxProduct(String[] param) {
        int result = 0;
        int lenth = param.length;
        int[] masks = new int[lenth];
        int[] lens = new int[lenth];
        for (int i=0;i<lenth;i++) {
            int bitMask = 0;
            for (char ch : param[i].toCharArray()) {
                bitMask |= 1 << bitNumber(ch);
            }
            masks[i] = bitMask;
            lens[i] = param[i].length();
        }
        for (int i=0; i<lenth; i++) {
            for (int j = i + 1; j < lenth; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    int value = lens[i] * lens[j];
                    result = Math.max(result, value);
                }
            }
        }
        return result;
    }

    // 官方解法,时间复杂度为O(n^2)
    private static int maxProduct2(String[] param) {
        int result = 0;
        int lenth = param.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<lenth; i++) {
            int bitMask = 0;
            for (char ch : param[i].toCharArray()) {
                bitMask |= 1<<bitNumber(ch);
            }
            map.put(bitMask, Math.max(map.getOrDefault(bitMask, 0),param[i].length()));
        }
        for (Integer x : map.keySet()) {
            for (Integer y : map.keySet()) {
                if ((x & y) == 0) {
                    result = Math.max(result, map.get(x) * map.get(y));
                }
            }
        }
        return result;
    }

    private static int bitNumber(char ch) {
        return (int)ch - (int)'a';
    }
}
