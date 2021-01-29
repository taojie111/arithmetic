package stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> q1 = new LinkedList<Integer>();
    private Queue<Integer> q2 = new LinkedList<Integer>();

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.top());
        System.out.println(myStack.isEmpty());
    }

    public void push(int x) {
        if (q1.isEmpty()) {
            q1.offer(x);
        }
        while(!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        q1.offer(x);
        while(!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
