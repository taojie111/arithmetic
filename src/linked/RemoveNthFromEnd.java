package linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,2,3,4,5";
        ListNode listNode = myLinkedList.stringToListNode(listStr);
//        ListNode node = remove(listNode,3);
        ListNode node = remove1(listNode,2);
        System.out.println(node);
    }

    // 自己的解法
    public static ListNode remove(ListNode node, int n) {
        ListNode curr = node;
        ListNode pre = null;
        ListNode temp1 = node;
        int lenth = 0;
        while (temp1!=null) {
            temp1 = temp1.next;
            lenth++;
        }
        if (n > lenth) {
            throw new RuntimeException("参数n不能大于链表的长度");
        }

        if (lenth < 2) {
            throw new RuntimeException("链表的长度不能小于2");
        }

        while (curr != null) {
            ListNode temp2= curr;
            for  (int i=1;i<=n;i++) {
                temp2 = temp2.next;
            }
            if (temp2 == null) {
                if (pre == null) {
                    ListNode temp3 = curr.next;
                    curr.next = null;
                    node = temp3;
                } else {
                    pre.next = curr.next;
                    curr.next = null;
                }
                break;
            } else {
                pre = curr;
                curr = curr.next;
            }

        }
        return node;
    }

    // 官方解法1
    public static ListNode remove1(ListNode node, int n) {
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
