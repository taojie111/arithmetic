package hot100;

import tree.common.TreeNode;
import tree.common.TreeUtil;

public class MaxPathSum {

    public static void main(String[] args) {
        int result = maxPathSum(TreeUtil.getTree39());
        System.out.println(result);
    }

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public static int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.getLeft()), 0);
        int rightGain = Math.max(maxGain(node.getRight()), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.getValue() + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.getValue() + Math.max(leftGain, rightGain);
    }

}
