package hot100;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taojie
 */
public class Rob {

    public static void main(String[] args) {
        int result = rob(TreeUtil.getTree36());
        System.out.println(result);
    }

    public static int doTest(TreeNode root) {
        return 0;
    }

    static Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    static Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public static int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.getLeft());
        dfs(node.getRight());
        f.put(node, node.getValue() + g.getOrDefault(node.getLeft(), 0) + g.getOrDefault(node.getRight(), 0));
        g.put(node, Math.max(f.getOrDefault(node.getLeft(), 0), g.getOrDefault(node.getLeft(), 0))
                + Math.max(f.getOrDefault(node.getRight(), 0), g.getOrDefault(node.getRight(), 0)));
    }
}
