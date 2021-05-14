package array;

import java.util.HashSet;
import java.util.Set;

public class ArrayNesting {

    public static void main(String[] args) {
        int[] param = new int[]{5,4,0,3,1,6,2};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] a) {
        int maxCount = 0;
        for (int i = 0; i < a.length; i++) {
            int count = 0;
             int temp = i;
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < a.length; j++) {
                if (j == 0) {
                    set.add(a[temp]);
                    temp = a[temp];
                    count++;
                    continue;
                }
                if (!set.contains(a[temp])) {
                    count++;
                    set.add(a[temp]);
                    temp = a[temp];
                } else {
                    break;
                }
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

}
