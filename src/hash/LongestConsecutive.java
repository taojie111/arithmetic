package hash;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.Arrays;

public class LongestConsecutive {

    public static void main(String[] args) {
        int[] param = new int[]{0,3,7,2,5,8,4,6,0,1};
        int result = doLongestConsecutive(param);
        System.out.println(result);
    }

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

}
