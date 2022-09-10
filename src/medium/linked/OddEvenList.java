package medium.linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

/**
 * @author taojie
 */
public class OddEvenList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,2,3,4,5";
        ListNode paramNode = myLinkedList.stringToListNode(listStr);
        ListNode result  = doTest(paramNode);
        System.out.println(result);
    }

    // 自己的实现
    public static ListNode doTest(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode result = null;
        ListNode odd = null;
        ListNode evenResult = null;
        ListNode even = null;
        ListNode pr = null;
        ListNode p = head;
        int index = 1;
        while (p != null) {
            if (index == 1) {
                result = new ListNode(p.val);
                odd = result;
            } else {
                if (index % 2 == 0) {
                    if (evenResult == null) {
                        evenResult = new ListNode(p.val);
                        even = evenResult;
                    } else {
                        even.next = new ListNode(p.val);
                        even = even.next;
                    }
                } else {
                    odd.next = new ListNode(p.val);
                    odd = odd.next;
                }
            }
            index++;
            p = p.next;
        }
        odd.next = evenResult;
        return result;
    }

}
