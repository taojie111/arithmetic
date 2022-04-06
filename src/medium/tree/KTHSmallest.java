package medium.tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taojie
 */
public class KTHSmallest {

    public static void main(String[] args) {
       int result = doTest(TreeUtil.getTree21(), 3);
        System.out.println(result);
    }

    public static int doTest(TreeNode root, int k) {
        List<Integer> list = traverse(root, new ArrayList<Integer>());
        return list.get(k-1);
    }

    // 遍历数组，把所有节点值放入数组中
    public static List<Integer> traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        traverse(root.getLeft(), list);
        list.add(root.getValue());
        traverse(root.getRight(), list);
        return list;
    }


}
