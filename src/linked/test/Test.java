package linked.test;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class Test {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr1 = "1,2,3,4";
        ListNode node = myLinkedList.stringToListNode(listStr1);
        ListNode head = new ListNode(0);
        head.next = node;
        ListNode reverse = reverse(head);
        System.out.println(reverse);
    }


    public static int factorial(int i) {
        if (i == 1) {
            return 1;
        }
        int m = factorial(i - 1);
        int returnVal = i * m;
        return returnVal;
    }

    public static int Chebonacci(int i) {
        if (i == 1 || i == 2) {
            return 1;
        }
        int m = Chebonacci(i - 1);
        int n = Chebonacci(i - 2);
        return m + n;
    }

  /*  public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverse(head.next);
        node.next = head;
        return node;
    }*/
    // 反转单链表
    // 1、明确功能：反转单链表
    // 2、结束条件：node == null，结束递归
    // 3、等价关系式：head = head.next, reverse(ListNode head);
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}

