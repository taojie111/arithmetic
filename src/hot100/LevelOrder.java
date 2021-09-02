package hot100;

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
        Queue<TreeNode> queue = new LinkedList<>();
        int current = 1;
        int next = 0;
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current--;
            int nodeValue = node.getValue();
            list.add(nodeValue);
            TreeNode leftNode = node.getLeft();
            TreeNode rightNode = node.getRight();
            if (leftNode != null) {
                queue.offer(leftNode);
                next++;
            }
            if (rightNode != null) {
                queue.offer(rightNode);
                next++;
            }
            if (current == 0) {
                result.add(new ArrayList<>(list));
                list.clear();
                current = next;
                next = 0;
            }
        }
        return result;
    }
}
