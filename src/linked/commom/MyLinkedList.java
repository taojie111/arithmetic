package linked.commom;

import linked.commom.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {

    public int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(0, input.length());
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.data) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public ListNode stringToCycleNode(String input) {
        int[] nodeValues = stringToIntegerArray(input);
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        ListNode node = null;
        for (int i = 0; i < nodeValues.length; i++) {
            if (i == nodeValues.length - 1) {
                ptr.next = node;
            } else {
                if (i == 1) {
                    node = new ListNode(nodeValues[i]);
                    ptr.next = node;
                } else {
                    ptr.next = new ListNode(nodeValues[i]);
                }
            }
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
}
