package sort;

public class HeapSort {

    static int len;

    public static void main(String[] args) {
        int[] param = new int[]{1,5,4,3,2,8,15,36,17,28,6};
        long start = System.currentTimeMillis();
        int[] result = heapSort2(param);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int[] heapSort2(int[] array) {
        len  = array.length;
        if (len == 0) {
            return null;
        }
        buildMaxHeap2(array);
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap2(array, 0);
        }
        return array;
    }

    public static void buildMaxHeap2(int[] array) {
        for (int i = (len - 2) / 2; i >= 0; i--) {
            adjustHeap2(array, i);
        }
    }

    public static void adjustHeap2(int[] array, int i) {
        int maxIndex = i;
        if (len == 0) {
            return;
        }
        if (2 * i + 1 < len && array[2 * i + 1] > array[maxIndex]) {
            maxIndex = 2 * i + 1;
        }
        if (2 * i + 2 < len && array[2 * i + 2] > array[maxIndex]) {
            maxIndex = 2 * i + 2;
        }
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap2(array, maxIndex);
        }
    }

    /**
     * 堆排序算法
     * 1、构建一个大根堆（父节点大于子节点）
     * 2、交换堆顶和堆尾节点，
     * 3、数组长度减1，
     * 4、重新构建大根堆
     * 5、循环执行2-4步，直到数组长度等于0
     * @param array
     * @return
     */
    public static int[] heapSort(int[] array) {
        len = array.length;
        if (len == 0) {
            return array;
        }
        //1.构建一个大根堆
        buildMaxHeap(array);
        //2.循环将堆顶（最大值）与堆尾交换，删除堆尾元素，然后重新调整大根堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--; //原先的堆尾进入有序区，删除堆尾元素
            adjustHeap(array, 0); //重新调整大根堆
        }
        return array;
    }

    /**
     * 自顶向下调整以 i 为根的堆为大根堆
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (2 * i + 1 < len && array[2 * i + 1] > array[maxIndex]) {
            maxIndex = 2 * i + 1;
        }
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (2 * i + 2 < len && array[2 * i + 2] > array[maxIndex]) {
            maxIndex = 2 * i + 2;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }

    /**
     * 自底向上构建初始大根堆
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始自底向上构造大根堆
        for (int i = (len - 2) / 2; i >= 0; i--) {
            adjustHeap(array, i);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
