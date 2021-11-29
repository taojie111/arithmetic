package hot100;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;
import util.PrintRecursionUtil;

import java.io.IOException;
import java.util.PriorityQueue;

/**
 * @author taojie
 */
public class MergeKLists {

    public static void main(String[] args) throws IOException {
        MyLinkedList myLinkedList = new MyLinkedList();
        String str1 = "1,4,5";
        String str2 = "1,3,4";
        String str3 = "2,6";
        ListNode e0 = myLinkedList.stringToListNode(str1);
        ListNode e1 = myLinkedList.stringToListNode(str2);
        ListNode e2 = myLinkedList.stringToListNode(str3);
        ListNode[] param = new ListNode[3];
        param[0] = e0;
        param[1] = e1;
        param[2] = e2;
        MergeKLists mergeKLists = new MergeKLists();
        ListNode result = mergeKLists.mergeKLists3(param);
        System.out.println(result);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        PrintRecursionUtil.printRecursion("l: " + l + ", " + "r: " + r, true);
        if (l == r) {
            PrintRecursionUtil.printRecursion("l: " + l + ", " + "r: " + r, false);
            return lists[l];
        }
        if (l > r) {
            PrintRecursionUtil.printRecursion("l: " + l + ", " + "r: " + r, false);
            return null;
        }
        int mid = (l + r) >> 1;
        ListNode merge1 = merge(lists, l, mid);
        ListNode merge2 = merge(lists, mid + 1, r);
        ListNode result = mergeTwoLists(merge1, merge2);
        PrintRecursionUtil.printRecursion("l: " + l + ", " + "r: " + r, false);
        return result;
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.data < bPtr.data) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    static PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists3(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.data, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.data, f.ptr.next));
            }
        }
        return head.next;
    }

}
