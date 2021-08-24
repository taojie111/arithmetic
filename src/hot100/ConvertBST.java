package hot100;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class ConvertBST {

    public static void main(String[] args) {
        TreeNode result = doTest(TreeUtil.getTree33());
        System.out.println(result);
    }

    public static TreeNode doTest(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    static TreeNode resultNode = new TreeNode();

    static List<Integer> list = new ArrayList<>();

    public static int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int rightValue = dfs(root.getRight(), sum);
        int nodeValue = (rightValue == 0 ? sum : rightValue)  + root.getValue();
        root.setValue(nodeValue);
        int leftValue = dfs(root.getLeft(), nodeValue);
        return nodeValue > leftValue ? nodeValue : leftValue;
    }
}
