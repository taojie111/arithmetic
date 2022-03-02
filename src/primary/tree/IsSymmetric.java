package primary.tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class IsSymmetric {

    public static void main(String[] args) {
        boolean result = doTest(TreeUtil.getTree27());
        System.out.println(result);
    }

    public static boolean doTest(TreeNode root) {
        String left = getStr(root.getLeft());
        String right = getStr2(root.getRight());
        return left.equals(right);
    }

    public static String getStr(TreeNode root) {
        if (root == null) {
            return "a";
        }
        return root.getValue() + getStr(root.getLeft()) + getStr(root.getRight());
    }

    public static String getStr2(TreeNode root) {
        if (root == null) {
            return "a";
        }
        return root.getValue() + getStr2(root.getRight()) + getStr2(root.getLeft());
    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root.getLeft(),root.getRight());
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean isEqual = p.getValue() == q.getValue();
        boolean c1 = check(p.getLeft(), q.getRight());
        boolean c2 = check(p.getRight(), q.getLeft());
        return isEqual && c1 && c2;
    }

}
