package wrong;

import tree.common.TreeNode;

/**
 * @author taojie
 */
public class BuildTree {

    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,3};
        int[] inorder = new int[]{2,3,1};
        TreeNode result = doTest(preorder, inorder);
        System.out.println(result);
    }

    public static TreeNode doTest(int[] preorder, int[] inorder) {
        return process(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode process(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (inLeft == inRight) {
            return new TreeNode(inorder[inLeft]);
        }
        int midValue = preorder[preLeft];
        TreeNode node = new TreeNode(midValue);
        int inMidIndex = getIndex(inorder, midValue);
        if (inMidIndex == inLeft) {
            node.left = null;
        } else {
            node.left = process(preorder, inorder, preLeft + 1, preLeft + inMidIndex - inLeft, inLeft, inMidIndex - 1);
        }
        if (inMidIndex == inRight) {
            node.right = null;
        } else {
            node.right = process(preorder, inorder, preLeft + inMidIndex - inLeft + 1, preRight, inMidIndex + 1, inRight);
        }
        return node;
    }

    public static int getIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
