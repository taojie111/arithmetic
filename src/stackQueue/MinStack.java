package stackQueue;

import java.util.Stack;

public class MinStack {

    Stack<Integer> s = new Stack<>();
    Stack<Integer> minS = new Stack<>();
    private int min;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    public MinStack() {

    }

    public void push(int x) {
        if (s.isEmpty()) {
            s.push(x);
            min = x;
            minS.push(x);
            return;
        }
        if (x < min) {
            min = x;
            minS.push(min);
        }
        s.push(x);
    }

    public int pop() {
        int result = s.pop();
        minS.pop();
        return result;
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        if (s.isEmpty()) {
            throw new RuntimeException("栈不能为空");
        }
        return minS.peek();
    }
}
