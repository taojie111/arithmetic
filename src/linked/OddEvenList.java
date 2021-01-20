package linked;

//给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
//示例 1:输入: 1->2->3->4->5->NULL，输出: 1->3->5->2->4->NULL
//示例 2:输入: 2->1->3->5->6->4->7->NULL，输出: 2->3->6->7->1->5->4->NULL

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class OddEvenList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16";
        ListNode paramNode = myLinkedList.stringToListNode(listStr);
        ListNode result  = doOddEvenList(paramNode);
        System.out.println(result);
    }

    // 自己的实现
    public static ListNode doOddEvenList(ListNode node){
        ListNode result = node;
        ListNode pEven = node;
        ListNode pOdd  = node.next;
        ListNode temp = pOdd;
        while (pEven != null && pOdd != null) {
            if (pEven.next != null) {
                if (pEven.next.next == null) {
                    pEven.next = temp;
                    pEven = null;
                } else {
                    pEven.next = pEven.next.next;
                    pEven = pEven.next;
                }
            }
            if (pOdd.next != null) {
                pOdd.next = pOdd.next.next;
                pOdd = pOdd.next;
            }
        }
        if (pEven != null) {
            pEven.next = temp;
        }
        return result;
    }

    public static ListNode oddEvenList(ListNode head){
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
