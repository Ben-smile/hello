package linkedlist;

public class LinkedList {

    public static void main(String[] args){
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node result = LinkedList.reverseNode(node1);
        LinkedList.showList(result);

    }


    //单向链表

    //内部类 Node节点
    static class Node{
        private int no;
        private Node next;

        public Node (int no){
            this.no = no;
        }

        public Node(){}

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    '}';
        }
    }

    //设计一个方法 反转单向链表

    public static Node reverseNode (Node head){
        //判断链表是否是空链表
        if(head.next == null || head.next.next == null){
            System.out.println("链表为空");
            return null;
        }

        //创建一个新的链表头
        Node newHead = new Node();
        Node cur = head.next; // 用来遍历链表

        while(cur != null){
            head.next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = head.next;

        }

        head.next = newHead.next;

        return head;
    }

    public static void showList(Node head){
        Node cur = new Node();

        cur = head;

        while(cur != null){
            System.out.println(cur);
            cur = cur.next;
        }
    }


}
