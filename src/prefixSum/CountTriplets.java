package prefixSum;

import java.util.HashMap;
import java.util.Map;

public class CountTriplets {

    public static void main(String[] args) {
        int[] param = new int[]{2,3,1,6,7};
        int result = countTriplets(param);
        System.out.println(result);
    }

    public static int countTriplets(int[] arr) {
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] ^ arr[i];
        }
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        Map<Integer, Integer> total = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int k = 0; k < n; ++k) {
            if (cnt.containsKey(s[k + 1])) {
                ans += cnt.get(s[k + 1]) * k - total.get(s[k + 1]);
            }
            cnt.put(s[k], cnt.getOrDefault(s[k], 0) + 1);
            total.put(s[k], total.getOrDefault(s[k], 0) + k);
        }
        return ans;
    }

}
