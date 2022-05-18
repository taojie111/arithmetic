package wrong;

import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class LongestUnivaluePath {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,null,3,1,1,1,1,1};
        int result = longestUnivaluePath(TreeUtil.createTree(arr));
        System.out.println(result);
    }

    public static int doTest(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root, Integer.MIN_VALUE, 0);
    }

    public static int process(TreeNode root, int preValue, int preNodeSum) {
        if (root == null) {
            return 0;
        }
        int curNodeSum = root.val == preValue ? preNodeSum + 1 : 0;
        int lNodeSum = process(root.left, root.val, curNodeSum);
        int rNodeSum = process(root.right, root.val, curNodeSum);
        if (root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val) {
            return Math.max(lNodeSum + rNodeSum, curNodeSum);
        }
        return lNodeSum >= rNodeSum ? Math.max(lNodeSum, curNodeSum) : Math.max(rNodeSum, curNodeSum);
    }

    static int ans;
    public static int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    public static int arrowLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
