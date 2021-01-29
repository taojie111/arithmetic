package stackqueue;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    private int front;

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.isEmpty());
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.isEmpty());
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            s1.push(x);
            front = x;
            return;
        }
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        front = s1.peek();
    }

    public int pop() {
        int result = s1.pop();
        if (!s1.empty()) {
            front = s1.peek();
        }
        return result;
    }

    public int peek() {
        return front;
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }
}
