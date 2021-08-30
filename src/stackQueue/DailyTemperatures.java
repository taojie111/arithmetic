package stackQueue;

import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] param = new int[]{73,74,75,71,69,72,76,73};
        int[] result = dailyTemperatures(param);
        System.out.println(result);
    }

    public static int[] dailyTemperatures(int[] arr) {
        int length = arr.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<length;i++) {
            int m = arr[i];
            while (!stack.isEmpty() && m > arr[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
