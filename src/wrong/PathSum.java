package wrong;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taojie
 */
public class PathSum {

    public static void main(String[] args) {
        int result = doTest(TreeUtil.getTree7().getLeft(), 8);
        System.out.println(result);
    }

    public static int doTest(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int sum = nodeSum(root, targetSum);
        sum += doTest(root.getLeft(), targetSum);
        sum += doTest(root.getRight(), targetSum);
        return sum;
    }

    public static int nodeSum(TreeNode root, int targetSum) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        if (root.getValue() == targetSum) {
            sum++;
        }
        sum += doTest(root.getLeft(), targetSum - root.getValue());
        sum += doTest(root.getRight(), targetSum - root.getValue());
        return sum;
    }

}
