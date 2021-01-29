package stackqueue;

import java.util.Stack;

//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
//示例：
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数；
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
public class NextGreaterElements {

    public static void main(String[] args) {
        int[] param = new int[]{1,2,1};
        int[] result = nextGreaterElements(param);
        System.out.println(result);
    }

    public static int[] nextGreaterElements(int[] arr) {
        int length = arr.length;
        int[] result = new int[]{-1,-1,-1};
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<2*length;i++) {
            int m = arr[i%length];
            while(!stack.isEmpty() && m > arr[stack.peek()]) {
                int index = stack.pop();
                result[index] = m;
            }
            stack.push(i%length);
        }
        return result;
    }

    // 自己的解法
    public static int[] doNextGreaterElements(int[] arr) {
        int length = arr.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<length;i++) {
            int m = arr[i];
            while(!stack.isEmpty() && m > arr[stack.peek()]) {
                int index = stack.pop();
                result[index] = m;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = -1;
            for (int i=0;i<index;i++) {
                int value = arr[index];
                if (arr[i] > value) {
                    result[index] = arr[i];
                    break;
                }
            }
        }
        return result;
    }
}
