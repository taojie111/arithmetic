package hot100;

import tree.common.TreeNode;
import tree.common.TreeUtil;

public class Flatten {

    public static void main(String[] args) {
        doTest(TreeUtil.getTree32());
        System.out.println();
    }

    public static void doTest(TreeNode root) {
        if (root == null || root.getLeft() == null) {
            return;
        }
        doTest(root.getLeft());
        doTest(root.getRight());
        TreeNode temp = root.getRight();
        root.setRight(root.getLeft());
        root.setLeft(null);
        TreeNode node = root.getRight();
        while (node.getRight() != null) {
            node = node.getRight();
        }
        node.setRight(temp);
    }

    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.getLeft() != null) {
                TreeNode next = curr.getLeft();
                TreeNode predecessor = next;
                while (predecessor.getRight() != null) {
                    predecessor = predecessor.getRight();
                }
                predecessor.setRight(curr.getRight());
                curr.setLeft(null);
                curr.setRight(next);
            }
            curr = curr.getRight();
        }
    }

}
