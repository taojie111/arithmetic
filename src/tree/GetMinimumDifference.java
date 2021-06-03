package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class GetMinimumDifference {

    static int pre;
    static int ans;

    public static void main(String[] args) {
        int result = doTest(TreeUtil.getTree25());
        System.out.println(result);
    }

    public static int doTest(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        inorder(root);
        return ans;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.getLeft());
        if (pre != -1) {
            ans = Math.min(ans, root.getValue() - pre);
        }
        pre = root.getValue();
        inorder(root.getRight());
    }
}
