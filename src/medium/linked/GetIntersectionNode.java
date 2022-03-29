package medium.linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

import java.io.IOException;

public class GetIntersectionNode {

    public static void main(String[] args) throws IOException {
        MyLinkedList myLinkedList = new MyLinkedList();
        // 输入4,1、5,6,1、8,4,5,构造两个相交链表4,1,8,4,5、5,6,1,8,4,5,相交点为8
       /* String str1 = "4,1";
        String str2 = "5,6,1";
        String str3 = "8,4,5";
        ListNode listA = myLinkedList.stringToListNode(str1);
        ListNode listB = myLinkedList.stringToListNode(str2);
        ListNode listC = myLinkedList.stringToListNode(str3);
        listA.next.next = listC;
        listB.next.next.next = listC;*/
        String str1 = "0";
        String str2 = "2,6,4";
        ListNode listA = myLinkedList.stringToListNode(str1);
        ListNode listB = myLinkedList.stringToListNode(str2);
        ListNode ret = getIntersectionNode(listA, listB);
        String out = myLinkedList.listNodeToString(ret);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}


