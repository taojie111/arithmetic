package wrong;

import tree.common.TreeNode;
import tree.common.TreeUtil;

public class Flatten {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,null,3};
        doTest(TreeUtil.createTree(arr));
        System.out.println();
    }

    public static void doTest(TreeNode root) {
        process(root);
        System.out.println(root);
    }

    public static TreeNode process(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = process(root.left);
        TreeNode right = process(root.right);
        if (left == null) {
            return root;
        }
        if (right == null) {
            root.right = left;
            root.left = null;
            return root;
        }
        TreeNode temp = left;
        while(temp.right  != null){
            temp = temp.right;
        }
        temp.right = right;
        root.right = left;
        root.left = null;
        return root;
    }

}
