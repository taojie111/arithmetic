package hot100;

import tree.common.TreeNode;
import tree.common.TreeUtil;

public class MaxDepth {

    public static void main(String[] args) {
        doTest(TreeUtil.getTree28());
        System.out.println(max);
    }
    static int max = 0;
    static int count = 0;

    public static void doTest(TreeNode root) {
        if (root == null) {
            return;
        }
        count++;
        max = Math.max(max, count);
        doTest(root.getLeft());
        if (root.getLeft() != null) {
            count--;
        }
        doTest(root.getRight());
        if (root.getRight() != null) {
            count--;
        }
    }

}
