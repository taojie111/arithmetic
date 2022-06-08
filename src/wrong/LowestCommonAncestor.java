package wrong;

import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{6,2,8,0,4,7,9,null,null,3,5};
        Integer[] arr2 = new Integer[]{2,0,4,null,null,3,5};
        Integer[] arr3 = new Integer[]{8,7,9};
        Integer[] arr4 = new Integer[]{3};
        Integer[] arr5 = new Integer[]{5};
        TreeNode result = lowestCommonAncestor(TreeUtil.createTree(arr1), TreeUtil.createTree(arr4), TreeUtil.createTree(arr5));
        System.out.println(result);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

}
