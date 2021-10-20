package hot100;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,2,3,4,5";
        ListNode listNode = myLinkedList.stringToListNode(listStr);
        ListNode node = doTest(listNode,2);
        System.out.println(node);
    }

    public static ListNode doTest(ListNode node, int n) {
        ListNode curr = node;
        ListNode temp = node;
        int lenth = getLenth(temp, n);
        for (int i = 1; i<lenth-n;i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return node;
    }

    public static int getLenth(ListNode node, int n) {
        int lenth = 0;
        while (node!=null) {
            node = node.next;
            lenth++;
        }
        return lenth;
    }
}
