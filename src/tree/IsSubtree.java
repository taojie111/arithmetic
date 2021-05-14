package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

public class IsSubtree {

    public static void main(String[] args) {
        boolean result = isSubtree(TreeUtil.getTree8(), TreeUtil.getTree9());
        System.out.println(result);
    }

    public static boolean doTest(TreeNode root, TreeNode subRoot) {
        return dfs2(root, subRoot);
    }

    public static boolean dfs2(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        boolean check = check2(s, t);
        boolean left = dfs(s.getLeft(), t);
        boolean right = dfs(s.getRight(), t);
        return check || left || right;
    }

    public static boolean check2(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.getValue() != t.getValue()) {
            return false;
        }
        boolean left = check2(s.getLeft(), t.getLeft());
        boolean right = check2(s.getRight(), t.getRight());
        return left || right;
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public static boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        boolean check = check(s, t);
        boolean left = dfs(s.getLeft(), t);
        boolean right = dfs(s.getRight(), t);
        return check || left || right;
    }

    public static boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.getValue() != t.getValue()) {
            return false;
        }
        boolean left = check(s.getLeft(), t.getLeft());
        boolean right = check(s.getRight(), t.getRight());
        return  left && right;
    }


}
