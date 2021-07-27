package hot100;

import java.util.Stack;

public class MinStack {

    public int[] stack = new int[10];
    public int[] stack2 = new int[10];
    int min1 = 0;
    int top = -1;

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
    }

    public void push(int val) {
        stack[++top] = val;
    }

    public void pop() {
        stack[top--] = 0;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return 0;
    }

}
