package hot100;

import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class MergeTrees {

    private static TreeNode node = new TreeNode();

    public static void main(String[] args) {
        TreeNode result = doTest(TreeUtil.getTree4(), TreeUtil.getTree5());
        System.out.println(result);
    }

    public static TreeNode doTest(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return new TreeNode(root2.getValue());
        }
        if (root2 == null) {
            return new TreeNode(root1.getValue());
        }
        TreeNode left = doTest(root1.getLeft(), root2.getLeft());
        TreeNode right = doTest(root1.getRight(), root2.getRight());
        TreeNode node = new TreeNode(root1.getValue() + root2.getValue());
        node.setLeft(left);
        node.setRight(right);
        return node;
    }

}
