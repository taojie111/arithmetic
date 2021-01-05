package linked.test;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class Test {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }


    public static int factorial(int i) {
        if (i == 1) {
            return 1;
        }
        int m = factorial(i-1);
        int returnVal = i*m;
        return  returnVal;
    }

    public static int Chebonacci(int i) {
        if (i == 1 || i== 2) {
            return 1;
        }
        int m = Chebonacci(i-1);
        int n = Chebonacci(i-2);
        return m + n;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverse(head.next);
        node.next = head;
        return node;
    }
}

