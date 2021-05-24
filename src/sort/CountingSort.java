package sort;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] param = new int[]{3,5,4,3,5,8,15,36,17,28,6};
        long start = System.currentTimeMillis();
        int[] result = countingSort(param);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int[] countingSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int bias, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }
        //计算偏移量，将 min ~ max 映射到 bucket 数组的 0 ~ (max - min) 位置上
        bias = -min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = 0, i = 0;
        while (index < array.length) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }
        return array;
    }

}
