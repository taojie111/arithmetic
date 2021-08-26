package hot100;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.*;

/**
 * @author taojie
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode result = lowestCommonAncestor2(TreeUtil.getTree34(), TreeUtil.getTree22(), TreeUtil.getTree23());
        System.out.println(result);
    }

    public static TreeNode doTest(TreeNode root, TreeNode p, TreeNode q) {

        return null;
    }

    private static TreeNode ans = null;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.getLeft(), p, q);
        boolean rson = dfs(root.getRight(), p, q);
        if ((lson && rson) || ((root.getValue() == p.getValue() || root.getValue() == q.getValue()) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.getValue() == p.getValue() || root.getValue() == q.getValue());
    }

    public static void dfs2(TreeNode root) {
        if (root.getLeft() != null) {
            parent.put(root.getLeft().getValue(), root);
            dfs2(root.getLeft());
        }
        if (root.getRight() != null) {
            parent.put(root.getRight().getValue(), root);
            dfs2(root.getRight());
        }
    }

    static Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();

    static Set<Integer> visited = new HashSet<Integer>();

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs2(root);
        while (p != null) {
            visited.add(p.getValue());
            p = parent.get(p.getValue());
        }
        while (q != null) {
            if (visited.contains(q.getValue())) {
                return q;
            }
            q = parent.get(q.getValue());
        }
        return null;
    }

}
