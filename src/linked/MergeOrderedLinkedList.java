package linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class MergeOrderedLinkedList {

    public static void main(String[] args) {
        // 测试递归
        MyLinkedList myLinkedList = new MyLinkedList();
       /* String listStr1 = "1,5,8";
        ListNode node1 = myLinkedList.stringToListNode(listStr1);

        String listStr2 = "3,4,9";
        ListNode node2 = myLinkedList.stringToListNode(listStr2);

        ListNode result1 = recursionMerge(node1, node2);
        System.out.println(result1);*/

        // 测试迭代
        String listStr3 = "1,4,5";
        ListNode node3 = myLinkedList.stringToListNode(listStr3);

        String listStr4 = "1,2,3,6";
        ListNode node4 = myLinkedList.stringToListNode(listStr4);

        ListNode result2 = iterationMerge(node3, node4);
        System.out.println(result2);
    }

    // 递归解法
    public static ListNode recursionMerge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        } else if (node1.val < node2.val) {
            node1.next = recursionMerge(node1.next, node2);
            return node1;
        } else {
            node2.next = recursionMerge(node1, node2.next);
            return node2;
        }
    }

    // 迭代解法
    public static ListNode iterationMerge(ListNode node1, ListNode node2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        ListNode p1 = node1;
        ListNode p2 = node2;
        while(p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                pre.next = p1;
                p1 = p1.next;
            } else {
                pre.next = p2;
                p2 = p2.next;
            }
            pre = pre.next;
        }
        pre.next = p1 == null ? p2 : p1;
        return preHead.next;
    }
}
