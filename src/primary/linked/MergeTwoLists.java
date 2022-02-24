package primary.linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

/**
 * @author taojie
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr1 = "1,2,4";
        ListNode node1 = myLinkedList.stringToListNode(listStr1);
        String listStr2 = "3,5,8";
        ListNode node2 = myLinkedList.stringToListNode(listStr2);
        doTest2(node1, node2);
        System.out.println(result);
    }

    public static ListNode doTest(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode p = result;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.data <= p2.data) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        p.next = p1 == null ? p2 : p1;
        return result.next;
    }

    public static ListNode result = new ListNode(-1);
    public static ListNode p = result;

    public static void doTest2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            p.next = l1 == null ? l2 : l1;
            return;
        }
        if (l1.data <= l2.data) {
            p.next = l1;
            p = p.next;
            doTest2(l1.next, l2);
        } else {
            p.next = l2;
            p = p.next;
            doTest2(l1, l2.next);
        }
    }

}
