package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {

    public static void main(String[] args) {
        List<Integer> result = preOrderTraversalWithIterate(TreeUtil.getTree16());
        System.out.println(result);
    }

    public static List<Integer> doTest(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preOrder(root, res);
        return res;
    }

    // 递归实现
    public static void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.getValue());
        preOrder(root.getLeft(), res);
        preOrder(root.getRight(), res);
    }

    // 迭代实现
    public static List<Integer> preOrderTraversalWithIterate(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            // 从根节点开始，先把节点值添加到集合中，再把左节点依次添加到栈中
            while (node != null) {
                res.add(node.getValue());
                stack.push(node);
                node = node.getLeft();
            }
            // 从栈中取出一个节点
            node = stack.pop();
            node = node.getRight();
        }
        return res;
    }
}
