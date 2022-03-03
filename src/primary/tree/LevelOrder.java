package primary.tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author taojie
 */
public class LevelOrder {

    public static void main(String[] args) {
        List<List<Integer>> result = doTest(TreeUtil.getTree35());
        System.out.println(result);
    }

    /**
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    public static List<List<Integer>> doTest(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curCount = 1;
        int nextCount = 0;
        List<Integer> item = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            item.add(node.getValue());
            curCount--;
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
                nextCount++;
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
                nextCount++;
            }
            if (curCount == 0) {
                result.add(item);
                item = new ArrayList<>();
                curCount = nextCount;
                nextCount = 0;
            }
        }
        return result;
    }

}
