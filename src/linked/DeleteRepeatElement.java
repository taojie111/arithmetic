package linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class DeleteRepeatElement {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,1,1,2,2,2,5,6,6,7,8,8,9,9,9,10,10,11,11,11,12,13,15,15,16,17,18,18,18";
        ListNode listNode = myLinkedList.stringToListNode(listStr);
        ListNode node = delete(listNode);
//        ListNode node = deleteDuplicates(listNode);
        System.out.println(node);
    }

    // 自己的解法,递归法
    public static ListNode delete(ListNode node) {
        if (node == null) {
            return node;
        }
        ListNode p = node;
        ListNode cycle = node;
        while(cycle != null) {
            ListNode temp = cycle.next;
            if (p != cycle) {
                    if (p.val == cycle.val) {
                    p.next = cycle.next;
                    cycle.next = null;
                }
            }
            cycle = temp;
        }
        ListNode rtnNode = delete(p.next);
        return p;
    }

    // 官方解法
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr.next != null && curr != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

}
