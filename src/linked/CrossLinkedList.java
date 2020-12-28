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
        // 输入[4,1]、[5,6,1]、[8,4,5],构造两个相交链表[4,1,8,4,5]、[5,6,1,8,4,5],相交点为8
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

    /*
    * 解题思路：双指针法
    * 1、设置两个指针分别指向两个相交链表的头结点
    * 2、移动两个指针，当指针到达链表尾指针指向的下一个节点时（也就是null），把指针指向另一个链表的头结点
    * 3、当循环完一轮后，第二轮两个指针肯定会相遇（指向同一个节点），此时，该节点就是两个指针的相交点
    * */
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


