package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] param = new int[]{1,5,3,4,2};
        long start = System.currentTimeMillis();
        int[] result = doTest(param);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int[] doTest(int[] param) {
        if (param.length == 1) {
            return param;
        }
        int length = param.length;
        int middle = length / 2;
        int start = 0;
        int end = param.length;
        int[] left = Arrays.copyOfRange(param, 0, middle);
        int[] right = Arrays.copyOfRange(param, middle, end);
        int[] a = doTest(left);
        int[] b = doTest(right);
        return merge(a, b);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
        return result;
    }
}
