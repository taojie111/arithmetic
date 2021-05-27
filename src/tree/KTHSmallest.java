package tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author taojie
 */
public class KTHSmallest {

//    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
       int result = kthSmallest(TreeUtil.getTree21(), 3);
        System.out.println(result);
    }

    public static int doTest(TreeNode root, int k) {
        List<Integer> list = traverse(root, new ArrayList<Integer>());
        Object[] objects = list.toArray();
        Arrays.sort(objects);
        return (Integer) objects[k -1];
    }

    // 遍历数组，把所有节点值放入数组中
    public static List<Integer> traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        list.add(root.getValue());
        traverse(root.getLeft(), list);
        traverse(root.getRight(), list);
        return list;
    }

    public static int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.getLeft();
            }
            if (--k == 0) {
                return root.getValue();
            }
            root = root.getRight();
        }

    }

}
