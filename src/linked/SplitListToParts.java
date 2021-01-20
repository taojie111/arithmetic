package linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class SplitListToParts {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,2,3,4,5,6";
        ListNode listNode = myLinkedList.stringToListNode(listStr);
        ListNode[] result = doSplitListToParts(listNode,3);
        System.out.println(result);
    }

    public static ListNode[] doSplitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }
        int width = N / k, rem = N % k;
        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = new ListNode(0), write = head;
            for (int j = 0; j < width + (i < rem ? 1 : 0); ++j) {
                write = write.next = new ListNode(cur.data);
                if (cur != null) {
                    cur = cur.next;
                }
            }
            ans[i] = head.next;
        }
        return ans;

    }
}
