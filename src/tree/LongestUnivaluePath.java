package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class LongestUnivaluePath {

    public static void main(String[] args) {
        int result = doTest(TreeUtil.getTree12());
        System.out.println(result);
    }

    public static int doTest(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 0;
    }

    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    public int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = arrowLength(node.getLeft());
        int right = arrowLength(node.getRight());

        int arrowLeft = 0, arrowRight = 0;
        if (node.getLeft() != null && node.getLeft().getValue() == node.getValue()) {
            arrowLeft += left + 1;
        }
        if (node.getRight() != null && node.getRight().getValue() == node.getValue()) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

}
