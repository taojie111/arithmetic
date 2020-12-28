package linked;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import linked.commom.ListNode;
import linked.commom.MyLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CrossLinkedList {

    public static void main(String[] args) throws IOException {
        MyLinkedList myLinkedList = new MyLinkedList();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode listA = myLinkedList.stringToListNode(line);
            line = in.readLine();
            ListNode listB = myLinkedList.stringToListNode(line);
            line = in.readLine();
            ListNode listC = myLinkedList.stringToListNode(line);
            listA.next = listC;
            listB.next = listC;
            ListNode headA = new ListNode(0);
            headA.next = listA;
            ListNode headB = new ListNode(1);
            headB.next = listB;
            ListNode ret = getIntersectionNode(headA, headB);
            String out = myLinkedList.listNodeToString(ret);
            System.out.print(out);
        }
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
        if (pA != null) {
            System.out.println(pA.data);
        }
        return pA;
    }
}


