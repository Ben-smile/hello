package util;

public class Node {
    public Node previous;
    public Node next;
    public int item;

    public Node (){}
    public Node (Node previous,int element,Node next){
        this.item = element;
        this.next = next;
        this.previous = previous;
    }
}
