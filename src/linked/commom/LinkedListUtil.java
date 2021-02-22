package linked.commom;

public class LinkedListUtil {

    public static int getLenth(ListNode node) {
        int lenth = 0;
        while (node!=null) {
            node = node.next;
            lenth++;
        }
        return lenth;
    }

}
