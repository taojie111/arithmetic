package greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author taojie
 */
public class eraseOverlapIntervals {

    public static void main(String[] args) {
        int[][] param = new int[4][2];
        param[0] = new int[]{1,2};
        param[1] = new int[]{2,3};
        param[2] = new int[]{3,4};
        param[3] = new int[]{1,3};
        int result = eraseOverlapIntervals(param);
        System.out.println(result);
    }

    public static int doTest(int[][] param) {

        return 0;
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}
