package util;

public class LinkedBox implements Box { //实现Box 接口
     
     private class Node {//创建一个Node类作为LinkedBox的内部类 每一个结点都是一个Node类型的对象
           //Node类属性 有 1.上一个Node对象的引用
                                         2.当前Node对象存入的值
		    3.下一个Node对象的引用
          private Node previous;
          private Node next;
          private int item;

          private Node (){}
          private Node (Node previous,int element,Node next){
          this.item = element;
          this.next = next;
          this.previous = previous;
    }
     //linkedBox的属性 1.头结点
		  2.尾节点
		  3.链表的长度size
    private Node first;
    private Node last;
    private int  size;

    //将元素存入一个新Node中并挂在链表的尾端
    private void linkLast(int element){
        Node l = last;
        Node newNode = new Node(l,element,null);
        last  = newNode;
        //判断链表是否有元素
        if(l == null){
            first = newNode;
        }else{
            l.next = newNode;
        }
        size++;
    }
     //检查index 的范围是否合法
    private void rangeCheck (int index){
        if (index <0 || index>=size){
           throw new BoxIndexOutOfBoundsException("size:"+size+"index:"+index);
        }
    }
    //找到index对应的Node 对象
    private Node findNode (int index){
        //判断 index是在size的左半边还是右半边
        Node targetNode;
        if (index < (size>>1)){  //左半边就从first开始找
            targetNode = first;
            for (int i = 0;i<index;i++){
                targetNode= targetNode.next;
            }
        }else {     //否则就从last开始找
            targetNode = last;
            for (int i = size-1;i>index;i--){
                targetNode= targetNode.previous;
            }
        }
        return targetNode;
    }
    //将要删除的节点删除 并返回删除元素的值
    private int unlink (Node targetNode){
        int oldValue = targetNode.item;
        Node prev = targetNode.previous;
        Node next = targetNode.next;
        if (prev == null){    //此时targetNode是头结点
            next = first;   
        }else{   //说明当前Node对象的前面还有Node对象
            prev.next = next; 
            targetNode.previous = null;  //help GC
        }
        if (next == null){  //此时是尾节点
            prev = last;
        }else{  //说明当前Node对象的后面还有Node对象
            next.previous = prev;
            targetNode.next = null;   //help GC
        }
        targetNode.item = null;  //help GC
        return oldValue;
    }
  //---------------------------------------------------------
    public boolean add(int element) {
        //调用连接尾节点的方法
        this.linkLast(element);
        return true;
    }


    public int remove(int index) {
         //1.先检查index 的范围
        this.rangeCheck(index);
         //2.获取index对应的Node对象
        Node targetNode =this.findNode(index);
         //3.删除Node结点并返回删除的值
        int value = this.unlink(targetNode);
         //4.让size长度减一
        size--;
        return value;
    }


    public int get(int index) {
        this.rangeCheck(index);
        Node targetNode = this.findNode(index);
        int value = targetNode.item;
        return value;
    }


    public int size() {
        return size;
    }
}
