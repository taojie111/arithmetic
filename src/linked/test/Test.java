package linked.test;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class Test {

    public static ListNode test(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB ) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        System.out.println(pA.data);
        return pA;
    }
}

