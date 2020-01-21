package util;

public class LinkedBox implements Box { //实现Box 接口

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
        }else {
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
        if (prev == null){
            next = first;
        }else{
            prev.next = next;
            targetNode.previous = null;
        }
        if (next == null){
            prev = last;
        }else{
            next.previous = prev;
            targetNode.next = null;
        }
        return oldValue;
    }
  //---------------------------------------------------------
    public boolean add(int element) {
        this.linkLast(element);
        return true;
    }


    public int remove(int index) {
        this.rangeCheck(index);
        Node targetNode =this.findNode(index);
        int value = this.unlink(targetNode);
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
