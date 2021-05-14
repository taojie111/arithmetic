package array;

import java.util.Arrays;

public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] param = new int[]{1,1,0,1,1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1};
        int result = doublePoint(param);
        System.out.println(result);
    }

    // 自己的解法
    public static int doFindMaxConsecutiveOnes(int[] param) {
        int count = 0;
        int index = 0;
        int[] arr = new int[10];
        for (int i=0;i<param.length;++i) {
            if (param[i] == 1) {
                count++;
            } else {
                arr[index] = count;
                count = 0;
                index++;
            }
            if (i == param.length - 1) {
                if (count != 0) {
                    arr[index] = count;
                }
            }
        }
        return Arrays.stream(arr).max().getAsInt();
    }

    // 官方解法
    public static int findMaxConsecutiveOnes(int[] param) {
        int length = param.length;
        int maxCount = 0;
        int count = 0;
        for (int i=0;i<param.length;++i) {
            if (param[i] == 0) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    // 双指针解法
    public static int doublePoint(int[] param) {
        int length = param.length;
        int left = 0;
        int right = 0;
        int maxCount = 0;
        for (int i=0;i<param.length;++i) {
            if (param[i] == 0) {
                left = right + 1;
            }
            maxCount = Math.max(right - left + 1, maxCount);
            right++;
        }
        return maxCount;
    }
}
