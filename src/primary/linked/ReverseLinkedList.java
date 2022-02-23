package primary.linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

/**
 * @author taojie
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,2,3,4,5";
        ListNode head = myLinkedList.stringToListNode(listStr);
        ListNode node = doTest(head);
        System.out.println(node);
    }

    public static ListNode doTest(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode p = doTest(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


}
