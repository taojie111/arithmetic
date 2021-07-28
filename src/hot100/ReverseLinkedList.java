package hot100;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

/**
 * @author taojie
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,2,3,4";
        ListNode head = myLinkedList.stringToListNode(listStr);
        ListNode result = doTest(head);
        System.out.println(result);
    }

    public static ListNode doTest(ListNode head) {
        // current.next.next = current
        if (head.next == null) {
            return head;
        }
        ListNode result = doTest(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

}
