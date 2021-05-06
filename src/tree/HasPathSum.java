package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author taojie
 */
public class HasPathSum {

    public static void main(String[] args) {
        boolean result = doTest(TreeUtil.getTree6(), 22);
        System.out.println(result);
    }

    public static boolean doTest(TreeNode root, int targetSum) {

        return true;
    }

    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        Queue<Integer> valueNodes = new LinkedList<>();
        treeNodes.offer(root);
        valueNodes.offer(root.getValue());
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.poll();
            int temp = valueNodes.poll();
            if (node.getLeft() == null && node.getRight() == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }

            if (node.getLeft() != null) {
                treeNodes.offer(node.getLeft());
                valueNodes.offer(node.getLeft().getValue() + temp);
            }

            if (node.getRight() != null) {
                treeNodes.offer(node.getRight());
                valueNodes.offer(node.getRight().getValue() + temp);
            }
        }
        return false;
    }

    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return targetSum == root.getValue();
        }

        return hasPathSum2(root.getLeft(), targetSum - root.getValue())
                || hasPathSum2(root.getRight(), targetSum - root.getValue());
    }
}
