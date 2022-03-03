package primary.tree;

import tree.common.TreeNode;

/**
 * @author taojie
 */
public class SortedArrayToBST {

    public static void main(String[] args) {
        int[] param = new int[]{-10,-3,0,5,9};
        TreeNode result = doTest(param);
        System.out.println(result);
    }

    /**
     *       0
     *      / \
     *    -3   9
     *    /   /
     * -10   5
     */
    public static TreeNode doTest(int[] nums) {
        return helper(nums, 0 , nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right ) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (right - left) / 2;
        TreeNode node = new TreeNode(nums[left + mid]);
        node.left = helper(nums, left, left + mid - 1);
        node.right = helper(nums, left + mid + 1, right);
        return node;
    }

}
