package sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    public static void main(String[] args) {
        int[] param = new int[]{3,5,4,3,5,8,15,36,17,28,6};
        long start = System.currentTimeMillis();
        int[] result = bucketSort(param);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int[] bucketSort(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++){
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

    /*桶映射函数：自己设计，要保证桶 i 的数均小于桶 j （i < j）的数，
      即必须桶间必须有序，桶内可以无序。这里桶映射函数为：(i - min) / arr.length*/
        int bucketNum = (max - min) / array.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for(int i = 0; i < array.length; i++){
            int num = (array[i] - min) / (array.length);
            bucketArr.get(num).add(array[i]);
        }

        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }

        int k = 0;
        for(int i = 0; i < bucketArr.size(); i++){
            for(int j = 0;j < bucketArr.get(i).size();j++) {
                array[k++] = bucketArr.get(i).get(j);
            }
        }
        return array;
    }
}
