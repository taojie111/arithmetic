package hot100;

import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    public static void main(String[] args) {
        String result = serialize(TreeUtil.getTree25());
        System.out.println(result);
    }

    public static String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public static TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public static String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.getValue()) + ",";
            str = rserialize(root.getLeft(), str);
            str = rserialize(root.getRight(), str);
        }
        return str;
    }

    public static TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.setLeft(rdeserialize(dataList));
        root.setRight(rdeserialize(dataList));

        return root;
    }

}
