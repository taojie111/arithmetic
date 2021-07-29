package hot100;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class IsPalindromeListNode {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,2,3,2,1";
        ListNode head = myLinkedList.stringToListNode(listStr);
        boolean result = doTest2(head);
        System.out.println(result);
    }

    public static boolean doTest1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.data);
            p = p.next;
        }
        int front = 0;
        int after = list.size() - 1;
        while (front <= after) {
            if (list.get(front).equals(list.get(after))) {
                return false;
            }
            front++;
            after--;
        }
        return true;
    }

    public static boolean doTest2(ListNode head) {
        ListNode copy = new ListNode(0);
        copy.next = head;
        return recursion(head, copy);
    }

    static int count = 1;

    public static boolean recursion(ListNode head, ListNode copy) {
        if (head == null) {
            return true;
        }
        boolean result = recursion(head.next, copy);
        if (!result) {
            return false;
        }
        for (int i = 0; i < count; i++) {
            copy = copy.next;
        }
        if (head.data != copy.data) {
            return false;
        }
        count++;
        return true;
    }

}
