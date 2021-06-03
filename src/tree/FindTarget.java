package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taojie
 */
public class FindTarget {

    public static void main(String[] args) {
        boolean result = doTest(TreeUtil.getTree25(), 9);
        System.out.println(result);
    }

    public static boolean doTest(TreeNode root, int target) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == target) {
                return true;
            }
            if (sum < target) {
                l++;
            } else {
                r++;
            }
        }
        return false;
    }

    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.getLeft(), list);
        list.add(root.getValue());
        inorder(root.getRight(), list);
    }
}
