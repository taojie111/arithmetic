package array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author taojie
 */
public class kthSmallest {

    public static void main(String[] args) {
        int[][] param = new int[5][5];
        param[0] = new int[]{1,4,7,11,15};
        param[1] = new int[]{2,5,8,12,19};
        param[2] = new int[]{3,6,9,16,22};
        param[3] = new int[]{10,13,14,17,24};
        param[4] = new int[]{18,21,23,26,30};
        int result = doTest(param, 6);
        System.out.println(result);
    }

    public static int doTest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }
}
