package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        int result = doTest(TreeUtil.getTree10());
        System.out.println(result);
    }

    public static int doTest(TreeNode root) {
        if (root.getLeft() == null && root.getRight() == null) {
            return root.getValue();
        }
        int sum1 = 0;
        int sum2 = 0;
        sum1 = doTest(root.getLeft());
        if (root.getRight().getLeft() == null && root.getRight().getRight() == null) {
            doTest(root.getRight());
        } else {
            sum2 = doTest(root.getRight());
        }
        return sum1 + sum2;
    }
}
