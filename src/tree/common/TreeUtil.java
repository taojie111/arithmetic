package tree.common;

/**
 * @author taojie
 */
public class TreeUtil {

    public static TreeNode getTree() {
        TreeNode node = new TreeNode();
        node.setValue(1);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        TreeNode node22 = new TreeNode();
        node22.setValue(7);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(3);
        TreeNode node32 = new TreeNode();
        node32.setValue(4);
        node21.setLeft(node31);
        node21.setRight(node32);
        TreeNode node41 = new TreeNode();
        node41.setValue(5);
        TreeNode node42 = new TreeNode();
        node42.setValue(6);
        node32.setLeft(node41);
        node32.setRight(node42);
        return node;
    }

    public static TreeNode getTree2() {
        TreeNode node = new TreeNode();
        node.setValue(3);
        TreeNode node21 = new TreeNode();
        node21.setValue(9);
        TreeNode node22 = new TreeNode();
        node22.setValue(20);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(3);
        TreeNode node32 = new TreeNode();
        node32.setValue(4);
        node22.setLeft(node31);
        node22.setRight(node32);
        return node;
    }

    public static TreeNode getTree3() {
        TreeNode node = new TreeNode();
        node.setValue(1);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        TreeNode node22 = new TreeNode();
        node22.setValue(2);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(3);
        TreeNode node32 = new TreeNode();
        node32.setValue(3);
        TreeNode node33 = new TreeNode();
        node31.setValue(3);
        TreeNode node34 = new TreeNode();
        node32.setValue(3);
        node21.setLeft(node31);
        node21.setRight(node32);
        node22.setLeft(node33);
        node22.setRight(node34);
        TreeNode node41 = new TreeNode();
        node41.setValue(4);
        TreeNode node42 = new TreeNode();
        node42.setValue(4);
        node31.setLeft(node41);
        node31.setRight(node42);
        return node;
    }
}