package wrong;

import linked.commom.ListNode;
import linked.commom.MyLinkedList;

/**
 * @author taojie
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        // 测试迭代
        String listStr1 = "2";
        ListNode node1 = myLinkedList.stringToListNode(listStr1);

        String listStr2 = "1";
        ListNode node2 = myLinkedList.stringToListNode(listStr2);

        ListNode result = doTest2(node1, node2);
        System.out.println(node1);
    }

    public static ListNode doTest(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result = null;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode pre = null;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                if (pre != null) {
                    pre.next = p1;
                } else {
                    result = p1;
                }
                pre = p1;
                p1 = p1.next;
            } else if (p1.val > p2.val) {
                if (pre != null) {
                    pre.next = p2;
                } else {
                    result = p2;
                }
                pre = p2;
                p2 = p2.next;
            } else {
                if (pre == null) {
                    result = p1;
                    pre = p1;
                    p1 = p1.next;
                } else {
                    pre = pre.next;
                    if (p1 == pre) {
                        p1 = pre.next;
                    } else {
                        p2 = pre.next;
                    }
                }
            }
        }
        if (p1 == null) {
            pre.next = p2;
        }

        if (p2 == null) {
            pre.next = p1;
        }
        return result;
    }

    public static ListNode doTest2(ListNode list1, ListNode list2) {
        ListNode result = null;
        if (list1.val < list2.val) {
            result = list1;
        } else if (list1.val > list2.val) {
            result = list2;
        } else {
            result = list1;
        }
        process(list1, list2, null);
        return result;
    }

    public static void process(ListNode p1, ListNode p2, ListNode pre) {
        if (p1 == null) {
            pre.next = p2;
            return;
        }
        if (p2 == null) {
            pre.next = p1;
            return;
        }
        if (p1.val < p2.val) {
            if (pre != null) {
                pre.next = p1;
            }
            process(p1.next, p2, p1);
        } else if (p1.val > p2.val) {
            if (pre != null) {
                pre.next = p2;
            }
            process(p1, p2.next, p2);
        } else {
            if (pre == null) {
                process(p1.next, p2, p1);
            } else {
                if (pre.next == p1) {
                    process(p1.next, p2, p1);
                } else {
                    process(p1, p2.next, p2);
                }
            }
        }
    }

    public static ListNode process2(ListNode p1, ListNode p2) {
        if (p1 == null && p2 == null) {
            return null;
        }
        if (p1 == null) {
            return p2;
        }
        if (p2 == null) {
            return p1;
        }
        if (p1.val < p2.val) {
            p1.next = process2(p1.next, p2);
            return p1;
        } else {
            p2.next = process2(p1, p2.next);
            return p2;
        }
    }
}
