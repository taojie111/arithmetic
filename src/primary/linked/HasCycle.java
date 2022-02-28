package primary.linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class HasCycle {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr1 = "3,2,0,-4";
        ListNode param = myLinkedList.stringToCycleNode(listStr1, 1);
        boolean result = doTest(param);
        System.out.println(result);
    }

    public static boolean doTest(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

}
