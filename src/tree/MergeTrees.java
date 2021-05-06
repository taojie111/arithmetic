package tree;

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
        TreeNode ln = doTest(root1 == null ? null : root1.getLeft(), root2 == null ? null : root2.getLeft());
        TreeNode rn = doTest(root1 == null ? null : root1.getRight(), root2 == null ? null : root2.getRight());
        if (root1 != null) {
            root1.setLeft(ln);
            root1.setRight(rn);
        }
        if (root1 == null) {
            root1 = root2;
        } else if (root1 != null && root2 != null) {
            root1.setValue(root1.getValue() + root2.getValue());
        }
        return root1;
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.getValue() + t2.getValue());
        merged.setLeft(mergeTrees(t1.getLeft(), t2.getLeft()));
        merged.setRight(mergeTrees(t1.getRight(), t2.getRight()));
        return merged;
    }
}
