package hot100;

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
        return check(root, root);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q==null) {
            return true;
        }
        if (p==null || q==null) {
            return false;
        }
        boolean result = p.getValue() == q.getValue()
                && check(p.getLeft(), q.getRight())
                && check(q.getLeft(), p.getRight());
        return result;
    }

}
