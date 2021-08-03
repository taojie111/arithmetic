package hot100;

import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        int result = doTest(TreeUtil.getTree29());
        System.out.println(result);
    }

    public static int doTest(TreeNode root) {
        if (root.getLeft() == null || root.getRight() == null) {
            return 1;
        }
        int left = doTest(root.getLeft());
        int right = doTest(root.getRight());
        return left + right;
    }

    public static int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int left = getMaxDepth(root.getLeft());
        int right = getMaxDepth(root.getRight());
        return left + right;
    }

}
