package hot100;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author taojie
 */
public class InorderTraversal {

    public static void main(String[] args) {
        List<Integer> result = doTest(TreeUtil.getTree26());
        System.out.println(result);
    }

    public static List<Integer> doTest(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.getLeft(), res);
        res.add(root.getValue());
        inorder(root.getRight(), res);
    }

}
