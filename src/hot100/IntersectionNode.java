package hot100;

import jdk.internal.dynalink.beans.StaticClass;
import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class IntersectionNode {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr1 = "4,1,8,4,5";
        ListNode param1 = myLinkedList.stringToIntersectNode(listStr1);
        String listStr2 = "5,0,1,8,4,5";
        ListNode param2 = myLinkedList.stringToIntersectNode2(listStr2);
        ListNode result = intersectionNode(param1, param2);
        System.out.println(result);
    }

    public static ListNode doTest(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != null) {
            if (pA == pB) {
                return pA;
            }
            pB = pB.next;
            if (pB == null) {
                pB = headB;
                pA = pA.next;
            }
        }
        return null;
    }

    public static ListNode intersectionNode(ListNode headA, ListNode headB) {
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
