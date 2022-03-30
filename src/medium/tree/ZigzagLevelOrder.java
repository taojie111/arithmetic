package medium.tree;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.*;

/**
 * @author taojie
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {
        List<List<Integer>> result = doTest(TreeUtil.getTree44());
        System.out.println(result);
    }

    public static List<List<Integer>> doTest(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        int currentLevel = 1;
        int nextLevel = 0;
        List<Integer> list = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                if (node.left != null) {
                    stack2.push(node.left);
                    nextLevel++;
                }
                if (node.right != null) {
                    stack2.push(node.right);
                    nextLevel++;
                }
                if (currentLevel > 0) {
                    list.add(node.val);
                    currentLevel--;
                }
                if (currentLevel == 0) {
                    result.add(new ArrayList<>(list));
                    list = new ArrayList<>();
                    currentLevel = nextLevel;
                    nextLevel = 0;
                }
            }
            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                if (node.right != null) {
                    stack1.push(node.right);
                    nextLevel++;
                }
                if (node.left != null) {
                    stack1.push(node.left);
                    nextLevel++;
                }
                if (currentLevel > 0) {
                    list.add(node.val);
                    currentLevel--;
                }
                if (currentLevel == 0) {
                    result.add(new ArrayList<>(list));
                    list = new ArrayList<>();
                    currentLevel = nextLevel;
                    nextLevel = 0;
                }
            }
        }
        return result;
    }

}
