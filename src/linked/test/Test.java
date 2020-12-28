package linked.test;

import linked.commom.MyLinkedList;

public class Test {
    public static void main(String[] args) {
        LinkList L=new LinkList();
        LinkList L1=L.createList();
        LinkList L2=L.createCircleList();
        System.out.println("判断L1链表是否有环："+L1.haveCircle());
        System.out.println("判断L2链表是否有环："+L2.haveCircle());
        System.out.println("有环链表的入口点的value值为："+(L2.firstCircleNode()).value);
        System.out.println("计算环的节点个数："+L2.getCircleNodeNum());
        System.out.println("L1链表的倒数第3个节点为："+L1.findReverseKNode(3).value);
        System.out.println("L1链表的节点元素为："+L1.toString());
        //创建两条相交链表L3、L4；
        LinkList L3=L.createList();
        LinkList L4=L.createList();
        //将L1链接在L3的末尾
        L3.createLink(L1);
        //将L1链接在L4的末尾
        L4.createLink(L1);
        System.out.println("判断L3和L4是否相交："+L3.isLinkCross(L4));
        System.out.println("两链表链接的节点元素的值为："+L3.LinkNode(L4).value);
        System.out.println("L3链表的节点元素为："+L3.toString());
        System.out.println("L4链表的节点元素为："+L4.toString());
    }
}

