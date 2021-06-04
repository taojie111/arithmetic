package tree;

import tree.common.TreeNode;

/**
 * @author taojie
 */
public class SortedArrayToBST {

    public static void main(String[] args) {
        int[] param = new int[]{-10,-3,0,5,9};
        TreeNode result = sortedArrayToBST(param);
        System.out.println(result);
    }

    public static TreeNode sortedArrayToBST(int[] param) {
        return helper(param, 0, param.length - 1);
    }

    // 函数等价关关系式：f(n) = root.f(n-1) + root.f(n+1)
    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode leftNode = helper(nums, left, mid - 1);
        TreeNode rightNode = helper(nums, mid + 1, right);
        root.setLeft(leftNode);
        root.setRight(rightNode);
        return root;
    }
}
