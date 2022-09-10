package linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

import java.util.ArrayList;
import java.util.List;

//判断一个链表是否为回文链表
//示例 1:输入: 1->2 输出: false
//示例 2:输入: 1->2->2->1 输出: true
public class Palindrome {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,2,5,2,1";
        ListNode paramNode = myLinkedList.stringToListNode(listStr);
        boolean result = isPalindrome(paramNode);
        System.out.println(result);
    }

    // 双指针遍历数组
    public static boolean isPalindrome(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        int front = 0;
        int back = list.size() - 1;
        while(front < back) {
            if (!list.get(front).equals(list.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
    private static ListNode frontPointer;

    public boolean isPalindromeWithRecursive(ListNode head) {
        frontPointer = head;
        boolean result =  recursivelyCheck(head);
        return result;
    }

    public static boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode == null) {
            return true;
        }
        boolean flag = recursivelyCheck(currentNode.next);
        if (!flag) {
            return false;
        }
        if (currentNode.val != frontPointer.val) {
            return false;
        }
        frontPointer = frontPointer.next;
        return true;
    }


}
