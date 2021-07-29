package hot100;

import tree.common.TreeNode;
import tree.common.TreeUtil;

public class InvertTree {

    public static void main(String[] args) {
        TreeNode result = doTest(TreeUtil.getTree());
        System.out.println(result);
    }

    public static TreeNode doTest(TreeNode root) {
        if (root == null || (root.getLeft() == null && root.getRight() == null)) {
            return root;
        }
        doTest(root.getLeft());
        doTest(root.getRight());
        TreeNode left = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(left);
        return root;
    }

}
