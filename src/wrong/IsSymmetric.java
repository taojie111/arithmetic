package wrong;

import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @author taojie
 */
public class IsSymmetric {

    public static void main(String[] args) {
        boolean result = doTest(TreeUtil.getTree27());
        System.out.println(result);
    }

    public static boolean doTest(TreeNode root) {
        return process(root, root);
    }

    // 比较两个节点的值是否相等
    public static boolean process(TreeNode p, TreeNode q){
        if (p == null && q==null) {
            return true;
        }
        if (p == null || q==null) {
            return false;
        }
        if (p.val == q.val && process(p.left,q.right) &&  process(p.right,q.left)) {
            return true;
        }
        return false;
    }

}
