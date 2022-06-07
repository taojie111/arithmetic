package wrong;

import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode result = lowestCommonAncestor(TreeUtil.getTree34(), TreeUtil.getTree22(), TreeUtil.getTree23());
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
