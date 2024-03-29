package sort;

public class Quicksort {

    public static void main(String[] args) {
        int[] param = new int[]{7, 2, 6, 1, 3, 5};
        long start = System.currentTimeMillis();
        quicksort(param, 0, param.length - 1);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void quicksort(int[] array, int left, int right) {
        if(left < right){
            int pos = partition(array, left, right);
            quicksort(array, left, pos - 1);
            quicksort(array, pos + 1, right);
        }
    }

    public static int partition(int[] array,int left,int right) {
        int begin = left;
        int end = right;
        int key = right;
        while (begin < end) {
            while (begin < end && array[begin] <= array[key]) {
                begin++;
            }
            while (begin < end && array[end] >= array[key]) {
                end--;
            }
            swap(array, begin , end);
        }
        swap(array, begin , key);
        return begin;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void doTest(int[] array) {
        partition(array, 0 , array.length - 1);
    }

    public static void partition2(int[] array, int left, int right) {
        int key = right;
    }
}
