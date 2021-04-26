package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        int result = doTest(TreeUtil.getTree());
        System.out.println(result);
    }

    public static int doTest(TreeNode root) {
        return getMaxDepth(root.getLeft()) + getMaxDepth(root.getRight());
    }

    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = getMaxDepth(root.getLeft());
            int rightHeight = getMaxDepth(root.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
