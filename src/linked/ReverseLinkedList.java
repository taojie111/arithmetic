package linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

import java.util.List;

public class ReverseLinkedList {

    public static void main(String[] args) {
        // 解法1
      /*  MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,2,3";
        ListNode listNode = myLinkedList.stringToListNode(listStr);
        ListNode head = new ListNode(0);
        head.next = listNode;
        ListNode reverse = reverse(head);
        System.out.println(reverse);*/

        // 解法2
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,2,3,4";
        ListNode listNode = myLinkedList.stringToListNode(listStr);
        ListNode head = new ListNode(0);
        head.next = listNode;
        ListNode node = recursionReverse(head);
        System.out.println(node);
    }

    /* 解法1: 迭代法
    * 1、遍历链表时，需要从链表头指针开始遍历（头指针需要自己生成，给定已知链表，就可以生成头指针），因为不知道的链表的第一个元素
    * 2、指定一个指针，先指向头结点，然后依次指向所有节点
    * 3、由于反转链表，需要知道前一个节点，需要初始化设置一个pre指针
    * 4、遍历下一个节点之前，由于需要下一个节点的地址，所以需要提前保存下一个节点
    * 5、设置curr节点的next指向pre节点
    * 6、遍历下一个节点时，需要知道前一个节点，所以需要提前把pre节点移动到curr节点处
    *
    * */
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public static ListNode reverse2(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = pre;
            pre = curr;
            curr = curr.next;
            pre.next = temp;
        }
        return pre;
    }

    /* 解法2：递归法
    * 用递归遍历每个节点，从尾结点开始，依次向前遍历，直到头结点为止，
    * 当节点为最后一个节点时（即尾节点，满足node.next = null），
    * 返回最后一个节点，不做任何指针移动操作，
    * 当节点不是尾节点时，执行指针操作（curr.next.next = curr，curr.next = null),
    * 把当前节点的下一个节点的next指针执行当前节点，然后把当前节点的next指针执行null，
    * 整个递归过程，实际上也是一个遍历迭代过程，在这个过程中，不需要保存当前节点的下一个节点以及前一个节点，
    * 因为对节点所有操作，不会涉及到前一个节点和后一个节点，所有操作根据当前指针都能完成
    * */
   public static ListNode recursionReverse(ListNode head) {
       if (head == null || head .next == null) {
           return head;
       }
       ListNode p = recursionReverse(head.next);
       head.next.next = head;
       head.next = null;
       return p;
   }

}
