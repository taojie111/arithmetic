package tree.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
        node31.setValue(1);
        TreeNode node32 = new TreeNode();
        node32.setValue(3);
        node21.setLeft(node31);
        node21.setRight(node32);
        TreeNode node33 = new TreeNode();
        node33.setValue(6);
        TreeNode node34 = new TreeNode();
        node34.setValue(9);
        node22.setLeft(node33);
        node22.setRight(node34);
        TreeNode node41 = new TreeNode();
        node41.setValue(5);
        node31.setRight(node41);
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

    public static TreeNode getTree4() {
        TreeNode node = new TreeNode();
        node.setValue(1);
        TreeNode node21 = new TreeNode();
        node21.setValue(3);
        TreeNode node22 = new TreeNode();
        node22.setValue(2);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(5);
        node21.setLeft(node31);
        return node;
    }

    public static TreeNode getTree5() {
        TreeNode node = new TreeNode();
        node.setValue(2);
        TreeNode node21 = new TreeNode();
        node21.setValue(1);
        TreeNode node22 = new TreeNode();
        node22.setValue(3);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(4);
        node21.setRight(node31);
        TreeNode node32 = new TreeNode();
        node32.setValue(7);
        node22.setRight(node32);
        return node;
    }

    public static TreeNode getTree6() {
        TreeNode node = new TreeNode();
        node.setValue(5);
        TreeNode node21 = new TreeNode();
        node21.setValue(4);
        TreeNode node22 = new TreeNode();
        node22.setValue(8);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(11);
        TreeNode node32 = new TreeNode();
        node32.setValue(13);
        TreeNode node33 = new TreeNode();
        node33.setValue(4);
        node21.setLeft(node31);
        node22.setLeft(node32);
        node22.setRight(node33);
        TreeNode node41 = new TreeNode();
        node41.setValue(7);
        TreeNode node42 = new TreeNode();
        node42.setValue(2);
        TreeNode node43 = new TreeNode();
        node43.setValue(1);
        node31.setLeft(node41);
        node31.setRight(node42);
        node33.setRight(node43);
        return node;
    }

    public static TreeNode getTree7() {
        TreeNode node = new TreeNode();
        node.setValue(10);
        TreeNode node21 = new TreeNode();
        node21.setValue(5);
        TreeNode node22 = new TreeNode();
        node22.setValue(-3);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(3);
        TreeNode node32 = new TreeNode();
        node32.setValue(2);
        TreeNode node33 = new TreeNode();
        node33.setValue(11);
        node21.setLeft(node31);
        node21.setRight(node32);
        node22.setRight(node33);
        TreeNode node41 = new TreeNode();
        node41.setValue(3);
        TreeNode node42 = new TreeNode();
        node42.setValue(-2);
        TreeNode node43 = new TreeNode();
        node43.setValue(1);
        node31.setLeft(node41);
        node31.setRight(node42);
        node32.setRight(node43);
        return node;
    }

    public static TreeNode getTree8() {
        TreeNode node = new TreeNode();
        node.setValue(3);
        TreeNode node21 = new TreeNode();
        node21.setValue(4);
        TreeNode node22 = new TreeNode();
        node22.setValue(5);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(1);
        TreeNode node32 = new TreeNode();
        node32.setValue(2);
        node21.setLeft(node31);
        node21.setRight(node32);
        return node;
    }

    public static TreeNode getTree9() {
        TreeNode node = new TreeNode();
        node.setValue(4);
        TreeNode node21 = new TreeNode();
        node21.setValue(1);
        TreeNode node22 = new TreeNode();
        node22.setValue(2);
        node.setLeft(node21);
        node.setRight(node22);
        return node;
    }

    public static TreeNode getTree10() {
        TreeNode node = new TreeNode();
        node.setValue(3);
        TreeNode node21 = new TreeNode();
        node21.setValue(9);
        TreeNode node22 = new TreeNode();
        node22.setValue(20);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(15);
        TreeNode node32 = new TreeNode();
        node32.setValue(7);
        node22.setLeft(node31);
        node22.setRight(node32);
        return node;
    }

    public static TreeNode getTree11() {
        TreeNode node = new TreeNode();
        node.setValue(2);

        TreeNode node21 = new TreeNode();
        node21.setValue(3);
        node.setRight(node21);

        TreeNode node31 = new TreeNode();
        node31.setValue(4);
        node21.setRight(node31);

        TreeNode node41 = new TreeNode();
        node41.setValue(5);
        node31.setRight(node41);

        TreeNode node51 = new TreeNode();
        node51.setValue(6);
        node41.setRight(node51);
        return node;
    }

    public static TreeNode getTree12() {
        TreeNode node = new TreeNode();
        node.setValue(5);
        TreeNode node21 = new TreeNode();
        node21.setValue(4);
        TreeNode node22 = new TreeNode();
        node22.setValue(5);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(1);
        TreeNode node32 = new TreeNode();
        node32.setValue(1);
        node21.setLeft(node31);
        node21.setRight(node32);
        TreeNode node33 = new TreeNode();
        node33.setValue(5);
        node22.setRight(node33);
        return node;
    }

    public static TreeNode getTree13() {
        TreeNode node = new TreeNode();
        node.setValue(3);
        TreeNode node21 = new TreeNode();
        node21.setValue(9);
        TreeNode node22 = new TreeNode();
        node22.setValue(20);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(15);
        TreeNode node32 = new TreeNode();
        node32.setValue(7);
        node22.setLeft(node31);
        node22.setRight(node32);
        return node;
    }

    public static TreeNode getTree14() {
        TreeNode node = new TreeNode();
        node.setValue(2);
        TreeNode node21 = new TreeNode();
        node21.setValue(1);
        TreeNode node22 = new TreeNode();
        node22.setValue(3);
        node.setLeft(node21);
        node.setRight(node22);
        return node;
    }

    public static TreeNode getTree15() {
        TreeNode node = new TreeNode();
        node.setValue(1);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        TreeNode node22 = new TreeNode();
        node22.setValue(3);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(4);
        TreeNode node32 = new TreeNode();
        node32.setValue(5);
        TreeNode node33 = new TreeNode();
        node33.setValue(6);
        node21.setLeft(node31);
        node22.setLeft(node32);
        node22.setRight(node33);
        TreeNode node41 = new TreeNode();
        node41.setValue(7);
        node32.setLeft(node41);
        return node;
    }

    public static TreeNode getTree16() {
        TreeNode node = new TreeNode();
        node.setValue(1);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        TreeNode node22 = new TreeNode();
        node22.setValue(3);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(4);
        TreeNode node32 = new TreeNode();
        node32.setValue(5);
        node21.setLeft(node31);
        node21.setRight(node32);
        TreeNode node41 = new TreeNode();
        node41.setValue(6);
        TreeNode node42 = new TreeNode();
        node42.setValue(7);
        node31.setLeft(node41);
        node31.setRight(node42);
        TreeNode node51 = new TreeNode();
        node51.setValue(8);
        TreeNode node52 = new TreeNode();
        node52.setValue(9);
        node42.setLeft(node51);
        node42.setRight(node52);
        return node;
    }

    public static TreeNode getTree17() {
        TreeNode node = new TreeNode();
        node.setValue(3);
        TreeNode node21 = new TreeNode();
        node21.setValue(0);
        TreeNode node22 = new TreeNode();
        node22.setValue(4);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(2);
        node21.setRight(node31);
        TreeNode node41 = new TreeNode();
        node41.setValue(1);
        node31.setLeft(node41);
        return node;
    }

    public static TreeNode getTree18() {
        TreeNode node = new TreeNode();
        node.setValue(3);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        TreeNode node22 = new TreeNode();
        node22.setValue(4);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(1);
        TreeNode node32 = new TreeNode();
        node32.setValue(6);
        node21.setLeft(node31);
        node21.setRight(node32);
        TreeNode node41 = new TreeNode();
        node41.setValue(1);
        node32.setLeft(node41);
        return node;
    }

    public static TreeNode getTree19() {
        TreeNode node = new TreeNode();
        node.setValue(6);
        TreeNode node21 = new TreeNode();
        node21.setValue(3);
        TreeNode node22 = new TreeNode();
        node22.setValue(7);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(2);
        TreeNode node32 = new TreeNode();
        node32.setValue(5);
        node21.setLeft(node31);
        node21.setRight(node32);
        TreeNode node41 = new TreeNode();
        node41.setValue(4);
        node32.setLeft(node41);
        return node;
    }

    public static TreeNode getTree20() {
        TreeNode node = new TreeNode();
        node.setValue(3);
        TreeNode node21 = new TreeNode();
        node21.setValue(1);
        TreeNode node22 = new TreeNode();
        node22.setValue(4);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(2);
        node21.setRight(node31);
        return node;
    }

    public static TreeNode getTree21() {
        TreeNode node = new TreeNode();
        node.setValue(5);
        TreeNode node21 = new TreeNode();
        node21.setValue(3);
        TreeNode node22 = new TreeNode();
        node22.setValue(6);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(2);
        TreeNode node32 = new TreeNode();
        node32.setValue(4);
        node21.setLeft(node31);
        node21.setRight(node32);
        TreeNode node41 = new TreeNode();
        node41.setValue(1);
        node31.setLeft(node41);
        return node;
    }

    public static TreeNode getTree22() {
        TreeNode node = new TreeNode();
        node.setValue(9);
        return node;
    }

    public static TreeNode getTree23() {
        TreeNode node = new TreeNode();
        node.setValue(11);
        return node;
    }

    public static TreeNode getTree24() {
        TreeNode node = new TreeNode();
        node.setValue(6);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        TreeNode node22 = new TreeNode();
        node22.setValue(8);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(0);
        TreeNode node32 = new TreeNode();
        node32.setValue(4);
        TreeNode node33 = new TreeNode();
        node33.setValue(7);
        TreeNode node34 = new TreeNode();
        node34.setValue(9);
        node21.setLeft(node31);
        node21.setRight(node32);
        node22.setLeft(node33);
        node22.setRight(node34);
        TreeNode node41 = new TreeNode();
        node41.setValue(3);
        TreeNode node42 = new TreeNode();
        node42.setValue(5);
        node32.setLeft(node41);
        node32.setRight(node42);
        return node;
    }

    public static TreeNode getTree25() {
        TreeNode node = new TreeNode();
        node.setValue(5);
        TreeNode node21 = new TreeNode();
        node21.setValue(3);
        TreeNode node22 = new TreeNode();
        node22.setValue(6);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(2);
        TreeNode node32 = new TreeNode();
        node32.setValue(4);
        TreeNode node33 = new TreeNode();
        node33.setValue(7);
        node21.setLeft(node31);
        node21.setRight(node32);
        node22.setRight(node33);
        return node;
    }

    public static TreeNode getTree26() {
        TreeNode node = new TreeNode();
        node.setValue(1);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        node.setRight(node21);
        TreeNode node31 = new TreeNode();
        node31.setValue(3);
        node21.setLeft(node31);
        return node;
    }

    public static TreeNode getTree27() {
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
        node32.setValue(4);
        TreeNode node33 = new TreeNode();
        node33.setValue(4);
        TreeNode node34 = new TreeNode();
        node34.setValue(3);
        node21.setLeft(node31);
        node21.setRight(node32);
        node22.setLeft(node33);
        node22.setRight(node34);
        return node;
    }

    public static TreeNode getTree28() {
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
        node32.setValue(4);
        TreeNode node33 = new TreeNode();
        node33.setValue(4);
        TreeNode node34 = new TreeNode();
        node34.setValue(3);
        node21.setLeft(node31);
        node21.setRight(node32);
        node22.setLeft(node33);
        node22.setRight(node34);
        TreeNode node41 = new TreeNode();
        node41.setValue(5);
        node31.setLeft(node41);
        TreeNode node42 = new TreeNode();
        node42.setValue(5);
        TreeNode node43 = new TreeNode();
        node43.setValue(5);
        node32.setLeft(node42);
        node32.setRight(node43);
        TreeNode node51 = new TreeNode();
        node51.setValue(5);
        node42.setRight(node51);
        return node;
    }

    public static TreeNode getTree29() {
        TreeNode node = new TreeNode();
        node.setValue(1);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        TreeNode node22 = new TreeNode();
        node22.setValue(3);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(4);
        TreeNode node32 = new TreeNode();
        node32.setValue(5);
        node21.setLeft(node31);
        node21.setRight(node32);
        return node;
    }

    public static TreeNode getTree30() {
        TreeNode node = new TreeNode();
        node.setValue(3);
        TreeNode node21 = new TreeNode();
        node21.setValue(9);
        TreeNode node22 = new TreeNode();
        node22.setValue(20);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(15);
        TreeNode node32 = new TreeNode();
        node32.setValue(17);
        node22.setLeft(node31);
        node22.setRight(node32);
        return node;
    }

    public static TreeNode getTree31() {
        TreeNode node = new TreeNode();
        node.setValue(1);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        TreeNode node22 = new TreeNode();
        node22.setValue(5);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(3);
        TreeNode node32 = new TreeNode();
        node32.setValue(4);
        TreeNode node33 = new TreeNode();
        node33.setValue(6);
        node21.setLeft(node31);
        node21.setRight(node32);
        node22.setRight(node33);
        return node;
    }

    public static TreeNode getTree32() {
        TreeNode node = new TreeNode();
        node.setValue(1);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        TreeNode node22 = new TreeNode();
        node22.setValue(5);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(3);
        TreeNode node32 = new TreeNode();
        node32.setValue(4);
        TreeNode node33 = new TreeNode();
        node33.setValue(6);
        node21.setLeft(node31);
        node22.setLeft(node32);
        node22.setRight(node33);
        return node;
    }

    public static TreeNode getTree33() {
        TreeNode node = new TreeNode();
        node.setValue(4);
        TreeNode node21 = new TreeNode();
        node21.setValue(1);
        TreeNode node22 = new TreeNode();
        node22.setValue(6);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(0);
        TreeNode node32 = new TreeNode();
        node32.setValue(2);
        node21.setLeft(node31);
        node21.setRight(node32);
        TreeNode node33 = new TreeNode();
        node33.setValue(5);
        TreeNode node34 = new TreeNode();
        node34.setValue(7);
        node22.setLeft(node33);
        node22.setRight(node34);
        TreeNode node41 = new TreeNode();
        node41.setValue(3);
        TreeNode node42 = new TreeNode();
        node42.setValue(8);
        node32.setRight(node41);
        node34.setRight(node42);
        return node;
    }

    public static TreeNode getTree34() {
        TreeNode node = new TreeNode();
        node.setValue(1);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        TreeNode node22 = new TreeNode();
        node22.setValue(3);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(4);
        TreeNode node32 = new TreeNode();
        node32.setValue(5);
        TreeNode node33 = new TreeNode();
        node33.setValue(6);
        TreeNode node34 = new TreeNode();
        node34.setValue(7);
        node21.setLeft(node31);
        node21.setRight(node32);
        node22.setLeft(node33);
        node22.setRight(node34);

        TreeNode node41 = new TreeNode();
        node41.setValue(8);
        TreeNode node42 = new TreeNode();
        node42.setValue(9);

        TreeNode node43 = new TreeNode();
        node43.setValue(10);
        TreeNode node44 = new TreeNode();
        node44.setValue(11);

        TreeNode node45 = new TreeNode();
        node45.setValue(12);
        TreeNode node46 = new TreeNode();
        node46.setValue(13);

        TreeNode node47 = new TreeNode();
        node47.setValue(14);
        TreeNode node48 = new TreeNode();
        node48.setValue(15);

        node31.setLeft(node41);
        node31.setRight(node42);

        node32.setLeft(node43);
        node32.setRight(node44);

        node33.setLeft(node45);
        node34.setRight(node46);

        node34.setLeft(node47);
        node34.setRight(node48);
        return node;
    }

    public static TreeNode getTree35() {
        TreeNode node = new TreeNode();
        node.setValue(3);
        TreeNode node21 = new TreeNode();
        node21.setValue(9);
        TreeNode node22 = new TreeNode();
        node22.setValue(20);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(15);
        TreeNode node32 = new TreeNode();
        node32.setValue(7);
        node22.setLeft(node31);
        node22.setRight(node32);
        return node;
    }

    public static TreeNode getTree36() {
        TreeNode node = new TreeNode();
        node.setValue(3);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        TreeNode node22 = new TreeNode();
        node22.setValue(3);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(3);
        TreeNode node32 = new TreeNode();
        node32.setValue(1);
        node21.setRight(node31);
        node22.setRight(node32);
        return node;
    }

    public static TreeNode getTree37() {
        TreeNode node = new TreeNode();
        node.setValue(1);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        TreeNode node22 = new TreeNode();
        node22.setValue(3);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(4);
        TreeNode node32 = new TreeNode();
        node32.setValue(5);
        node21.setRight(node31);
        node22.setRight(node32);
        return node;
    }

    public static TreeNode getTree38() {
        TreeNode node = new TreeNode();
        node.setValue(2);
        TreeNode node21 = new TreeNode();
        node21.setValue(1);
        TreeNode node22 = new TreeNode();
        node22.setValue(3);
        node.setLeft(node21);
        node.setRight(node22);
        return node;
    }

    public static TreeNode getTree39() {
        TreeNode node = new TreeNode();
        node.setValue(1);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        TreeNode node22 = new TreeNode();
        node22.setValue(3);
        node.setLeft(node21);
        node.setRight(node22);
        return node;
    }

    public static TreeNode getTree40() {
        TreeNode node = new TreeNode();
        node.setValue(1);
        TreeNode node21 = new TreeNode();
        node21.setValue(1);
        node.setLeft(node21);
        return node;
    }

    public static TreeNode getTree41() {
        TreeNode node = new TreeNode();
        node.setValue(5);
        TreeNode node21 = new TreeNode();
        node21.setValue(4);
        TreeNode node22 = new TreeNode();
        node22.setValue(6);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(3);
        TreeNode node32 = new TreeNode();
        node32.setValue(7);
        node22.setLeft(node31);
        node22.setRight(node32);
        return node;
    }

    public static TreeNode getTree42() {
        TreeNode node = new TreeNode();
        node.setValue(2);
        TreeNode node21 = new TreeNode();
        node21.setValue(1);
        TreeNode node22 = new TreeNode();
        node22.setValue(4);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(7);
        TreeNode node32 = new TreeNode();
        node32.setValue(4);
        node21.setLeft(node31);
        node21.setRight(node32);

        TreeNode node33 = new TreeNode();
        node33.setValue(8);
        TreeNode node34 = new TreeNode();
        node34.setValue(3);
        node22.setLeft(node33);
        node22.setRight(node34);

        TreeNode node41 = new TreeNode();
        node41.setValue(6);
        TreeNode node42 = new TreeNode();
        node42.setValue(4);
        node31.setLeft(node41);
        node31.setRight(node42);

        TreeNode node43 = new TreeNode();
        node43.setValue(7);
        node32.setLeft(node43);
        return node;
    }

    public static TreeNode getTree43() {
        TreeNode node = new TreeNode();
        node.setValue(3);
        TreeNode node21 = new TreeNode();
        node21.setValue(9);
        TreeNode node22 = new TreeNode();
        node22.setValue(20);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(15);
        TreeNode node32 = new TreeNode();
        node32.setValue(7);
        node22.setLeft(node31);
        node22.setRight(node32);
        return node;
    }

    public static TreeNode getTree44() {
        TreeNode node = new TreeNode();
        node.setValue(1);
        TreeNode node21 = new TreeNode();
        node21.setValue(2);
        TreeNode node22 = new TreeNode();
        node22.setValue(3);
        node.setLeft(node21);
        node.setRight(node22);
        TreeNode node31 = new TreeNode();
        node31.setValue(4);
        TreeNode node32 = new TreeNode();
        node32.setValue(5);
        node21.setLeft(node31);
        node22.setRight(node32);
        return node;
    }

    public static TreeNode createTree(Integer[] arr) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>(16);
        TreeNode root = null;
        int len = arr.length;
        int nNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                nNum++;
                continue;
            }
            TreeNode node = nodeMap.get(i);
            if (node == null) {
                node = new TreeNode(arr[i]);
                nodeMap.put(i, node);
            }
            if (i == 0) {
                root = node;
            }
            int leftIndex = 2 * (i - nNum) + 1;
            int rightIndex = 2 * (i - nNum) + 2;
            if (leftIndex < len && arr[leftIndex] != null) {
                node.left = new TreeNode(arr[leftIndex]);
                nodeMap.put(leftIndex, node.left);
            }
            if (rightIndex < len && arr[rightIndex] != null) {
                node.right = new TreeNode(arr[rightIndex]);
                nodeMap.put(rightIndex, node.right);
            }
        }
        return root;
    }
}
