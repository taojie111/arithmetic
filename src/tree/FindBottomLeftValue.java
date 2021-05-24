package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author taojie
 */
public class FindBottomLeftValue {

    public static void main(String[] args) {
        int result = doTest(TreeUtil.getTree());
        System.out.println(result);
    }

    public static int doTest(TreeNode root) {
        int result = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    result = node.getValue();
                }

                if (node.getLeft() == null && node.getRight() == null) {
                    count++;
                }

                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            if (count == size) {
                return result;
            }
        }
        return result;
    }
}
