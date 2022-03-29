package medium.linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class AddTwoNumbers {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr1 = "2,4,3,7";
        ListNode node1 = myLinkedList.stringToListNode(listStr1);
        String listStr2 = "5,6,4";
        ListNode node2 = myLinkedList.stringToListNode(listStr2);
        ListNode node = doTest(node1, node2);
        System.out.println(node);
    }

    public static ListNode doTest(ListNode node1, ListNode node2) {
        ListNode p1 = node1;
        ListNode p2 = node2;
        ListNode result = null;
        ListNode pr = null;
        int carry = 0;
        while (p1 != null || p2 != null || carry != 0) {
            int value1 = 0;
            int value2 = 0;
            if (p1 != null) {
                value1 = p1.data;
            }
            if (p2 != null) {
                value2 = p2.data;
            }
            int sum = value1 + value2 + carry;
            carry = sum / 10;
            int current = sum % 10;
            if (result == null) {
                result = new ListNode(current);
                pr = result;
            } else {
                pr.next = new  ListNode(current);
                pr = pr.next;
            }
            p1 = p1 != null ? p1.next : null;
            p2 = p2 != null ? p2.next : null;
        }
        return result;
    }

}
