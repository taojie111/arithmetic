package primary.tree;

import linked.test.Node;
import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class IsValidBST {

    public static void main(String[] args) {
        boolean result = isValidBST(TreeUtil.getTree42());
        System.out.println(result);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.getValue() <= min || root.getValue() >= max) {
            return false;
        }
        boolean l = isValidBST(root.getLeft(), min, root.getValue());
        boolean r = isValidBST(root.getRight(), root.getValue(), max);
        return l && r;
    }

}
