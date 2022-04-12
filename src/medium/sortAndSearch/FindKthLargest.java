package medium.sortAndSearch;

import java.util.Random;

/**
 * @author taojie
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] param = new int[]{3, 2, 1, 5, 6, 4};
        int result = doTest(param, 2);
        System.out.println(result);
    }

    private static Random random = new Random();

    public static int doTest(int[] nums, int k) {
        return 0;
    }


    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
