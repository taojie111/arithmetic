package linked.test;

public class Node{
    int value;
    Node next;
    public Node(){
        //注意调用时必须处在构造方法的第一行
        this(0);
    }
    public Node(int val){
        this.value=val;
        this.next=null;
    }
}
