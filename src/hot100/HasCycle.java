package hot100;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class HasCycle {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr1 = "1,2,3,5";
        ListNode param = myLinkedList.stringToListNode(listStr1);
        boolean result = doTest(param);
        System.out.println(result);
    }

    public static boolean doTest(ListNode param) {
        ListNode slow = param;
        ListNode fast = param.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
