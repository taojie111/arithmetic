package medium.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author taojie
 */
public class Connect {

    public static void main(String[] args) {
        Node result = doTest(new Connect().getTree());
        System.out.println(result);
    }

    public static Node doTest(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        int nodeCount = 1;
        Node preNode = null;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (nodeCount > 1) {
                if (preNode == null) {
                    preNode = node;
                } else {
                    preNode.next = node;
                    preNode = node;
                }
                nodeCount--;
            } else if (nodeCount == 1) {
                if (preNode != null) {
                    preNode.next = node;
                }
                level++;
                nodeCount = square(level);
                preNode = null;
            }
        }
        return root;
    }

    public static int square(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * 2;
        }
        return result;
    }

    public Node getTree() {
        Node node11 = new Node(1);
        Node node21 = new Node(2);
        Node node22 = new Node(3);
        Node node31 = new Node(4);
        Node node32 = new Node(5);
        Node node33 = new Node(6);
        Node node34 = new Node(7);
        node11.left = node21;
        node11.right = node22;
        node21.left = node31;
        node21.right = node32;
        node22.left = node33;
        node22.right = node34;
        return node11;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
