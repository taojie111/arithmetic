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
        List<Integer> result = postOrderWithIterate(TreeUtil.getTree16());
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
        postOrder(root.getLeft(), res);
        postOrder(root.getRight(), res);
        res.add(root.getValue());
    }

    public static List<Integer> postOrderWithIterate(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        TreeNode p1 = root, p2 = null;
        while (p1 != null) {
            p2 = p1.getLeft();
            if (p2 != null) {
                while (p2.getRight() != null && p2.getRight() != p1) {
                    p2 = p2.getRight();
                }
                if (p2.getRight() == null) {
                    p2.setRight(p1);
                    p1 = p1.getLeft();
                    continue;
                } else {
                    p2.setRight(null);
                    addPath(res, p1.getLeft());
                }
            }
            p1 = p1.getRight();
        }
        addPath(res, root);
        return res;
    }

    public static void addPath(List<Integer> res, TreeNode node) {
        int count = 0;
        while (node != null) {
            ++count;
            res.add(node.getValue());
            node = node.getRight();
        }
        int left = res.size() - count, right = res.size() - 1;
        while (left < right) {
            int temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);
            left++;
            right--;
        }
    }
}
