package tree;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import tree.common.TreeNode;
import tree.common.TreeUtil;

public class TrimBST {

    public static void main(String[] args) {
        TreeNode result = trimBST(TreeUtil.getTree19(), 1, 3);
        System.out.println(result);
    }

    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        if (root.getValue() > R) {
            return trimBST(root.getLeft(), L, R);
        }
        if (root.getValue() < L) {
            return trimBST(root.getRight(), L, R);
        }
        TreeNode leftNode = trimBST(root.getLeft(), L, R);
        root.setLeft(leftNode);
        TreeNode rightNode = trimBST(root.getRight(), L, R);
        root.setRight(rightNode);
        return root;
    }

}
