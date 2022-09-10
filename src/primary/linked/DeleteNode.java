package primary.linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class DeleteNode {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "4,5,1,9";
        ListNode head = myLinkedList.stringToListNode(listStr);
        doTest(head.next);
    }

    public static void doTest(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
