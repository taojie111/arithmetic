package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author taojie
 */
public class PostorderTraversal {

    public static void main(String[] args) {
        List<Integer> result = doTest(TreeUtil.getTree16());
        System.out.println(result);
    }

    public static List<Integer> doTest(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postOrder(root, res);
        return res;
    }

    public static void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.getValue());
        postOrder(root.getLeft(), res);
        postOrder(root.getRight(), res);
    }

    public static List<Integer> postOrderWithIterate(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                root = root.getLeft();
            }
            node = stack.pop();
            if (root.getRight() == null || root.getRight() == node) {
                res.add(root.getValue());
                node = root;
                root = null;
            } else {
                stack.push(root);
                root = root.getRight();
            }
        }
        return res;
    }
}
