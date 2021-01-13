package linked;

//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//示例：
//输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

import java.util.Deque;
import java.util.LinkedList;

public class AddTwoNumbers {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr1 = "7,2,4,3";
        ListNode node1 = myLinkedList.stringToListNode(listStr1);
        String listStr2 = "5,6,4";
        ListNode node2 = myLinkedList.stringToListNode(listStr2);
        ListNode node = doAddTwoNumbers(node1, node2);
        System.out.println(node);
    }

    // 自己的解法
    public static ListNode doAddTwoNumbers(ListNode node1, ListNode node2) {
        Deque<Integer> d1 = new LinkedList<Integer>();
        Deque<Integer> d2 = new LinkedList<Integer>();
        while (node1 != null) {
            d1.push(node1.data);
            node1 = node1.next;
        }
        while (node2 != null) {
            d2.push(node2.data);
            node2 = node2.next;
        }

        ListNode rtn = null;
        int carry = 0;

        while (!d1.isEmpty() || !d2.isEmpty() || carry !=0) {
            int a = d1.isEmpty() ? 0 : d1.pop();
            int b = d2.isEmpty() ? 0 : d2.pop();
            int sum = a + b + carry;
            int curr = sum % 10;
            carry = sum / 10;
            ListNode tmp = new ListNode(curr);
            tmp.next = rtn;
            rtn = tmp;
        }

        return rtn;
    }

    public static ListNode addTwoNumbersWithOfficial(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<Integer>();
        Deque<Integer> stack2 = new LinkedList<Integer>();
        while (l1 != null) {
            stack1.push(l1.data);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.data);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }
}
