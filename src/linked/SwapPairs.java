package linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

import java.util.List;

// 两两交换链表中的节点
public class SwapPairs {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,2,3,4,5,6";
        ListNode listNode = myLinkedList.stringToListNode(listStr);
//        ListNode node = doSwapPairs(listNode);
        ListNode node = swapPairsWithOfficial(listNode);
        System.out.println(node);
    }

    // 自己的迭代解法
    public static ListNode doSwapPairs(ListNode node) {
        if (node == null) {
            return null;
        }

        if (node.next == null) {
            return node;
        }

        ListNode pre = node;
        ListNode rear = node.next;

        ListNode rtn = rear;
        while(rear != null) {
            pre.next = rear.next;
            rear.next = pre;
            ListNode temp = pre;

            pre = pre.next;
            if (pre == null) {
                break;
            }
            rear = pre.next;
            if (rear != null) {
                temp.next = rear;
            }
        }
        return rtn;
    }


    // 官方的迭代解法
    public static ListNode swapPairsWithOfficial(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode pre = temp.next;
            ListNode rear = temp.next.next;
            temp.next = rear;
            pre.next = rear.next;
            rear.next = pre;
            temp = pre;
        }
        return dummyHead.next;
    }

    // 官方的递归解法
    public static ListNode swapPairsWithRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode node = swapPairsWithRecursion(newHead.next);
        head.next = node;
        newHead.next = head;
        return newHead;
    }
}
