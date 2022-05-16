package wrong;

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
        if (root == null) {
            return false;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return targetSum == root.getValue() ? true : false;
        }
        boolean isLeft = false;
        if (root.getLeft() != null) {
            isLeft = doTest(root.getLeft(), targetSum - root.getValue());
        }
        if (isLeft) {
            return true;
        }
        boolean isRight = false;
        if (root.getRight() != null) {
            isRight = doTest(root.getRight(), targetSum - root.getValue());
        }
        if (isRight) {
            return true;
        }
        return isLeft || isRight;
    }

}
