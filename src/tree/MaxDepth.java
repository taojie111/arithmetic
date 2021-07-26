package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

public class MaxDepth {

    public static void main(String[] args) {
        int result = maxDepth(TreeUtil.getTree());
        System.out.println(result);
    }

    public static int doTest(TreeNode root) {
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        int max = 1 + Math.max(doTest(root.getLeft()), doTest(root.getRight()));
        return max;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.getLeft());
        int rightHeight = maxDepth(root.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
