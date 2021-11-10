package hot100;

import tree.common.TreeNode;
import tree.common.TreeUtil;

public class IsValidBST {

    public static void main(String[] args) {
        boolean result = isValidBST(TreeUtil.getTree38());
        System.out.println(result);
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.getValue() <= lower || node.getValue() >= upper) {
            return false;
        }
        return isValidBST(node.getLeft(), lower, node.getValue()) && isValidBST(node.getRight(), node.getValue(), upper);
    }

}
