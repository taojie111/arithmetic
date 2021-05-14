package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

public class InvertTree {

    public static void main(String[] args) {
        TreeNode result = doTest(TreeUtil.getTree());
        System.out.println(result);
    }

    public static TreeNode doTest(TreeNode root) {
        if (root == null) {
            return null;
        }
        doTest(root.getLeft());
        doTest(root.getRight());
        swap(root);
        return root;
    }

    public static void swap(TreeNode root) {
        TreeNode left = root.getLeft();
        TreeNode temp = left;
        TreeNode right = root.getRight();
        root.setLeft(right);
        root.setRight(temp);
    }

}
