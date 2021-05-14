package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taojie
 */
public class FindShortestSubArray {

    public static void main(String[] args) {
        int[] param = new int[]{1, 2, 2, 3, 1};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] param) {
        Map<Integer,int[]> map = new HashMap<>(param.length);
        for (int i = 0; i < param.length; ++i) {
            int num = param[i];
            if (map.containsKey(num)) {
                int[] arr = map.get(num);
                arr[0]++;
                arr[2] = i;
            } else {
                int[] arr = new int[3];
                arr[0] = 1;
                arr[1] = i;
                arr[2] = i;
                map.put(num, arr);
            }
        }
        int maxNum = 0;
        int minLen = 0;
        for (Map.Entry<Integer,int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            }
            if (maxNum == arr[0]) {
                int len = arr[2] - arr[1] + 1;
                if (len < minLen) {
                    minLen = len;
                }
            }
        }
        return minLen;
    }

}
