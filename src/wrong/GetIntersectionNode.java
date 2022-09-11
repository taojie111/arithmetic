package wrong;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

import java.io.IOException;

public class GetIntersectionNode {

    public static void main(String[] args) throws IOException {
        MyLinkedList myLinkedList = new MyLinkedList();
        String str1 = "4,1,8,4,5";
        String str2 = "5,6,1,8,4,5";
        ListNode listA = myLinkedList.stringToListNode(str1);
        ListNode listB = myLinkedList.stringToListNode(str2);
        ListNode result = getIntersectionNode(listA, listB);
        System.out.println(result);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}


