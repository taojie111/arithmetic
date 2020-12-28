package linked.test;

import java.util.Random;

public class LinkList{
    Node head;

    public LinkList(){
        //调用Node的第一个构造方法
        this.head=new Node();
    }

    //头插法
    public void insertHead(int val){
        Node n=new Node(val);
        n.next=this.head.next;
        head.next=n;
    }

    //判断有环的思路为两个节点，fast走两步，slow走一步，若fast和slow最终相等，则证明有环，否则不会相等
    public boolean haveCircle(){
        if(head==null) {
            return false;
        }
        Node fast=head;
        Node slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==slow) {
            return true;
        } else {
            return false;
        }
    }

    //碰撞点到入口点的距离等于head到入口点的距离
    public Node firstCircleNode(){
        if(!this.haveCircle()){
            return null;
        }
        Node fast=head.next.next;
        Node slow=head.next;
        while(fast!=slow){
            fast=fast.next.next;
            slow=slow.next;
        }
        Node p=head;
        while(p!=slow){
            p=p.next;
            slow=slow.next;
        }
        return p;
    }

    //第一次相交与第二次相交slow所走过的节点个数；
    public int getCircleNodeNum(){
        if(!this.haveCircle()) {
            return 0;//如果没有环则返回0；
        }
        Node fast=head.next.next;
        Node slow=head.next;
        Node f1=null;Node f2=null;
        int count=0;
        while(f1==null || f2==null){
            if(fast==slow && f1!=null){
                f2=fast;
            }
            if(fast==slow && f1==null){
                f1=fast;
            }
            if(f1!=null && f2==null){
                count ++;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return count;
    }

    //私有方法用来返回链表的节点数
    private int listNode(LinkList list){
        int n=-1;
        Node p=list.head;
        while(p!=null){
            p=p.next;
            n+=1;
        }
        return n;
    }

    //分别求出两个链表的个数，让个数多的先走k（多的个数）步
    private Node LinkCross(LinkList list){
        //两链表相交，则从交点处汇聚为一条链
        Node p=this.head;
        Node q=list.head;
        if(p==null || q==null) {
            return null;
        }
        int np=listNode(this);
        int nq=listNode(list);
        int n=np-nq;
        while(n>0){
            p=p.next;
            n--;
        }
        while(n<0){
            q=q.next;
            n++;
        }
        while(p!=null || q!=null){
            if(p==q) {
                break;
            }
            p=p.next;q=q.next;
        }
        if (p==q) {
            return p;
        } else {
            return null;
        }
    }
    public boolean isLinkCross(LinkList list){
        //判断是否相交
        Node p=LinkCross(list);
        if (p==null) {
            return false;
        } else {
            return true;
        }
    }

    public Node LinkNode(LinkList list){
        return LinkCross(list);
    }

    //返回倒数第K个节点时间复杂度为O(n)
    public Node findReverseKNode(int k){
        int n=listNode(this);
        if(n<k) {
            return null;
        }
        Node f=head;
        Node s=head;
        while(k>0){
            f=f.next;
            k--;
        }
        while(f!=null){
            f=f.next;
            s=s.next;
        }
        return s;
    }
    public String toString(){
        StringBuilder builder=new StringBuilder();
        if(haveCircle()){
            return "链表有环";
        }
        Node n=head;
        while(n.next!=null){
            builder.append(n.next.value+" ");
            n=n.next;
        }
        return builder.toString();
    }

    //随机生成单链表
    public LinkList createList(){
        LinkList L=new LinkList();
        for(int i=0;i<10;i++){
            L.insertHead((int)(Math.random()*10));
        }
        return L;
    }

    //随机生成带环链表
    public LinkList createCircleList(){
        LinkList L=createList();
        Random r=new Random();
        int k=r.nextInt(10);
        //System.out.printf("环的入口节点为第%d个\n",k);
        Node p=L.head;
        Node q=L.head;
        while(p.next!=null){
            if(k==0) {
                //随机环的入口节点
                q=p.next;
            }
            k--;
            p=p.next;
        }
        //链接形成环；
        p.next=q;
        return L;
    }
    public void createLink(LinkList List){
        Node p=head;
        while(p.next!=null){
            p=p.next;
        }
        p.next=List.head.next;
    }
}
