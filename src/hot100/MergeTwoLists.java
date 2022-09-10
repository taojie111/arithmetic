package hot100;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

/**
 * @author taojie
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        // 测试迭代
        String listStr1 = "1,2,4";
        ListNode node1 = myLinkedList.stringToListNode(listStr1);

        String listStr2 = "3,5,8";
        ListNode node2 = myLinkedList.stringToListNode(listStr2);

        ListNode result = mergeTwoLists2(node1, node2);
        System.out.println(result);
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static ListNode doTest(ListNode node1, ListNode node2) {
        ListNode p1 = node1;
        ListNode p2 = node2;
        ListNode tmp1 = null;
        ListNode tmp2 = null;
        ListNode pre = null;
        while(p1 != null || p2 != null) {
            if (p1 == null) {
                pre.next = p2;
                p2 = null;
                continue;
            }
            if (p2 == null) {
                p1 = null;
                continue;
            }
            if (p1.val == p2.val) {
                tmp1 = p1.next;
                tmp2 = p2.next;
                p1.next = p2;
                p2.next = tmp1;
                pre = p1;
                p1 = tmp1;
                p2 = tmp2;
            } else if (p1.val < p2.val) {
                pre = p1;
                p1 = p1.next;
            } else if (p1.val > p2.val) {
                tmp2 = p2.next;
                pre.next = p2;
                p2.next = p1;
                pre = p2;
                p2 = tmp2;
            }
        }
        return node1;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

}
