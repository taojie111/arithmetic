package primary.tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class MaxDepth {

    public static void main(String[] args) {
        System.out.println(doTest(TreeUtil.getTree13()));
    }

    public static int doTest(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = doTest(root.getLeft());
        int r = doTest(root.getRight());
        return Math.max(l,r) + 1;
    }

}
