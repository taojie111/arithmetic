package hot100;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author taojie
 */
public class DetectCycle {

    public static void main(String[] args) throws IOException {
        MyLinkedList myLinkedList = new MyLinkedList();
        String str = "3,2,0,-4";
        ListNode param = myLinkedList.stringToCycleNode(str, 1);
//        ListNode param = myLinkedList.stringToListNode(str);
        ListNode result = doTest2(param);
        System.out.println(result);
    }

    public static ListNode doTest(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>(16);
        ListNode ptr = head;
        while (ptr != null) {
            if (map.getOrDefault(ptr,0) > 0) {
                return ptr;
            }
            map.put(ptr, map.getOrDefault(ptr,0) + 1);
            ptr = ptr.next;
        }
        return null;
    }

    public static ListNode doTest2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode ptr = head;
        while (slow != fast || (slow == head && fast == head)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != ptr) {
            slow = slow.next;
            ptr = ptr.next;
        }
        return ptr;
    }

}
