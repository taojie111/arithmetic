package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author taojie
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode result = doTest(TreeUtil.getTree24(), TreeUtil.getTree22(), TreeUtil.getTree23());
        System.out.println(result);
    }

    public static TreeNode doTest(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = getPath(root, p);
        List<TreeNode> qPath = getPath(root, q);
        TreeNode result = null;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i).getValue() == qPath.get(i).getValue()) {
                result = pPath.get(i);
            } else {
                break;
            }
        }
        return result;
    }

    public static List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> result = new ArrayList<>();
        TreeNode node = root;
        while (node.getValue() != target.getValue()) {
            result.add(node);
            if (node.getValue() > target.getValue()) {
                node = node.getLeft();
            } else if (node.getValue() < target.getValue()) {
                node = node.getRight();
            }
        }
        result.add(node);
        return result;
    }
}
