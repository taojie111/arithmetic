package hot100;

import java.util.Arrays;
import java.util.Comparator;

public class ReconstructQueue {

    public static void main(String[] args) {
        int[][] param = new int[6][2];
        int[] r1 = new int[]{7,0};
        int[] r2 = new int[]{4,4};
        int[] r3 = new int[]{7,1};
        int[] r4 = new int[]{5,0};
        int[] r5 = new int[]{6,1};
        int[] r6 = new int[]{5,2};
        param[0] = r1;
        param[1] = r2;
        param[2] = r3;
        param[3] = r4;
        param[4] = r5;
        param[5] = r6;
        int[][] result = reconstructQueue(param);
        System.out.println(result);
    }

    public static int[][] doTest(int[][] people) {
        return null;
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person2[1] - person1[1];
                }
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
