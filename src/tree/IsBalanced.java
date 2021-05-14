package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class IsBalanced {

    public static void main(String[] args) {
        boolean result = doTest(TreeUtil.getTree3());
        System.out.println(result);
    }

    public static boolean doTest(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();
        doTest(left);
        doTest(right);
        // f(n) = |max(n.left) - max(n.right)| > 1
        if (Math.abs(getMaxDepth(left) - getMaxDepth(right)) > 1) {
            return false;
        }
        return true;
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
