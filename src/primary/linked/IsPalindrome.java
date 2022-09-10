package primary.linked;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

public class IsPalindrome {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        String listStr = "1,2,3,4";
        ListNode head = myLinkedList.stringToListNode(listStr);
        boolean result = isPalindrome(head);
        System.out.println(result);
    }

    public static boolean doTest(ListNode head) {
        String s = "";
        StringBuilder sb = new StringBuilder();
        while (head!=null) {
            sb.append(head.val);
            head = head.next;
        }
        s = sb.toString();
        int left = 0;
        int right = 0;
        int lenth = s.length();
        int mid = lenth / 2;
        left = mid - 1;
        right = lenth % 2 == 0 ? mid : mid + 1;
        while (left >= 0 && right <= lenth - 1) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null){
            slow = slow.next;
        }
        while(pre != null && slow != null){
            if(pre.val != slow.val){
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
