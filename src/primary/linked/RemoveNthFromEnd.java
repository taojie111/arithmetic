package primary.linked;

import linked.commom.LinkedListUtil;
import linked.commom.ListNode;
import linked.commom.MyLinkedList;

/**
 * @author taojie
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,2";
        ListNode listNode = myLinkedList.stringToListNode(listStr);
        ListNode node = doTest(listNode,2);
        System.out.println(node);
    }

    public static ListNode doTest(ListNode node, int n) {
        int length = LinkedListUtil.getLenth(node);
        ListNode pre = null;
        ListNode cur = node;
        int index = 1;
        if (length == 1) {
            return null;
        }
        if ( length - n + 1 == 1) {
            node = node.next;
            return node;
        }
        while (index <= length - n + 1) {
            if (index == length - n) {
                pre = cur;
            }
            if (index == length - n + 1) {
                pre.next = cur.next;
            }
            index++;
            cur = cur.next;
        }
        return node;
    }
    

}
