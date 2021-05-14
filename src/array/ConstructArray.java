package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author taojie
 */
public class ConstructArray {

    public static void main(String[] args) {
        int[] result = doTest(3,2);
        System.out.println(result);
    }

    public static int[] doTest(int n, int k) {
        int[] arr = constructArray(n, k);

        int[] result = getArr(arr, k);
        if (result != null) {
            return result;
        }
        return doTest(n, k);
    }

    private static int[] getArr(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - 1];
        for (int i = 0; i < n-1; i++) {
            result[i] = Math.abs(arr[i] - arr[i+1]);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n-1; i++) {
            set.add(result[i]);
        }
        if (set.size() == k) {
            return result;
        }
        return null;
    }

    public static int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for  (int i = 0; i < n; i++) {
            //产生1~n个数
            res[i] = i + 1;
        }
        if (k == 1) {
            //k==1直接返回
            return res;
        }
        //k != 1就要翻转k - 1次，每次翻转保留前m个数
        for (int m = 1; m < k; m++) {
            reverse(res, m, n - 1);
        }
        return res;
    }

    // 翻转数组[i,j]之间的数
    public static void reverse(int[] res, int i, int j){
        while(i < j){
            int t = res[i];
            res[i] = res[j];
            res[j] = t;
            i++;
            j--;
        }
    }
}
