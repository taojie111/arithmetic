package stackqueue;

import java.util.Stack;

//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替
//例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] param = new int[]{23,24,25,21,19,22,26,23};
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
