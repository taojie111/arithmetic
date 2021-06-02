package tree;

import linked.commom.LinkedListUtil;
import linked.commom.ListNode;
import linked.commom.MyLinkedList;
import tree.common.TreeNode;

/**
 * @author taojie
 */
public class SortedListToBST {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr1 = "-10,-3,0,5,9";
        ListNode listNode = myLinkedList.stringToListNode(listStr1);
        TreeNode result = sortedArrayToBST(listNode);
        System.out.println(result);
    }

    public static TreeNode sortedArrayToBST(ListNode param) {
        return helper(param, 0, LinkedListUtil.getLenth(param) - 1);
    }

    public static TreeNode helper(ListNode nums, int left, int right) {
        if (left < right) {
            return null;
        }
        int mid = (left + right) / 2;

        return null;
    }

}
