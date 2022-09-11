package wrong;

import tree.common.TreeNode;
import tree.common.TreeUtil;

public class MaxDepth {

    public static void main(String[] args) {
        int max= doTest(TreeUtil.getTree28());
        System.out.println(max);
    }

    public static int doTest(TreeNode root) {
        return process(root);
    }

    public static int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(process(root.left), process(root.right)) + 1;
    }

}
