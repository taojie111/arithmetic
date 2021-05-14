package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class MinDepth {

    public static void main(String[] args) {
        int result = doTest(TreeUtil.getTree10());
        System.out.println(result);
    }

    public static int doTest(TreeNode root) {
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }
        int sum1 = 1;
        int sum2 = 1;
        if (root.getLeft() != null) {
            sum1 = sum1 + doTest(root.getLeft());
        } else {
            sum1 = Integer.MAX_VALUE;
        }
        if (root.getRight() != null) {
            sum2 = sum2 + doTest(root.getRight());
        } else {
            sum2 = Integer.MAX_VALUE;
        }
        return Math.min(sum1, sum2);
    }

}
