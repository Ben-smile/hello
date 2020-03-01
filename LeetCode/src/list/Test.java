package list;


import java.util.List;

public class Test {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {


        if(head == null){
            return null; //空链表
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                cur = prev.next;
            }
            prev = cur;
            cur = cur.next;

        }
        if (head.val==val){
            head = head.next;
        }
        return head;
    }



    // 诸如链表为空等特殊情况一定要重点考虑到
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;//记录cur的下一个节点
            if(next == null){//此时的cur为尾节点 或者原链表只有一个元素
                cur.next=prev;
                return cur; //返回cur
            }
            cur.next = prev; //反转
            prev = cur;
            cur = next;
        }
        return cur; //原链表为空链表 直接返回cur
    }

        //返回一个链表的中间值
    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int i = getListSize(head);

        for (int j = 0;j< i>>1;j++){
            cur = cur.next;
        }
        return cur;
    }
    public  int getListSize(ListNode head){
        ListNode cur = head;
        int i = 0;
        for (;cur != null;i++){
            cur = cur.next;
        }
        return i;
    }


    public ListNode FindKthToTail(ListNode head,int k) {

        int size = this.getListSize(head);
        if(size < k){
            return null;
        }
        ListNode cur = head;
        for (int i = 0;i<size-k;i++){
            cur = cur.next;
        }
        return cur;
    }

//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 ==null){
            return null;
        }
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        while(l1 != null && l2 !=null){
            if(l1.val <= l2.val){
                newTail.next = new ListNode(l1.val);
                newTail = newTail.next;
                l1 = l1.next;
            }else{
                newTail.next = new ListNode(l2.val);
                newTail = newTail.next;
                l2=l2.next;
            }
        }
        if(l1 == null){
            newTail.next = l2;
        }
        if(l2 == null){
            newTail.next = l1;
        }
        return newHead.next;
    }

//
    public ListNode partition(ListNode pHead, int x) {
        if(pHead ==null){
            return null;
        }
        if(pHead.next == null){
            return pHead;
        }
        ListNode cur = pHead; //遍历pHead
        ListNode bigHead = new ListNode(0);
        ListNode bigTail = bigHead;
        ListNode smallHead = new ListNode(0);
        ListNode smallTail = smallHead;
        while (cur != null){
            if (cur.val >= x){
                bigTail.next = new ListNode(cur.val); //连接时创建新node 此时next一定为null
                bigTail = bigTail.next;
                cur = cur.next;
            }else{
                smallTail.next =new ListNode(cur.val);
                smallTail = smallTail.next;
                cur = cur.next;
            }
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

//7. 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null) {
            return null;
        }
        ListNode cur = pHead;  //查找原链表的节点
        ListNode newHead = new ListNode(0); //新节点的头
        ListNode newTail = newHead; //新节点的尾
        while(cur != null) {
            if (cur.next!=null && cur.val == cur.next.val) {  //注意 cur.next是否为空 否则出现空指针异常
                while (cur.next!=null && cur.val == cur.next.val) {
                    cur = cur.next;
                }  //循环结束 cur指向重复元素的最后一个位置
                cur =cur.next; //再次进行后移 则cur就指向了 一个非重复元素
            }else{  //将非重复元素存入新的链表之中
                newTail.next = new ListNode(cur.val); //连接的时候 new一个新节点 此时新节点的next一定为空
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }

//判断一个链表是否回文 要求时间复杂度O(n) 空间复杂度 为O(1)
    public boolean chkPalindrome(ListNode A) {
        //1.求得链表的长度
        int size = getListSize(A);
        //2.从一半处 逆置后半部分链表
        ListNode cur = A;
        int step = size>>1;
        for (int i = 0;i<step;i++){
            cur = cur.next;
        }
        //循环结束得到的 链表的中间节点 cur
        ListNode newHead = new ListNode(0);
        ListNode prev = null;
        while (cur != null){
            ListNode next = cur.next;
            if(cur.next == null){ //此时cur是链表的最后一个节点
                newHead = cur;  //更新头结点
            }
            cur.next = prev; //完成逆序
            prev = cur;
            cur = next;
        }
        //3.比较 前半部分的链表 和逆序后的后半部分链表是否相等
        int after = getListSize(newHead);
        //注意此时链表的长度为奇数时 两个链表长度一样 若为偶数是 此时的中间值是第二个 所以before长度长
        //要以after的长度为基准
        for (int i = 0;i<after;i++){
            if(A.val != newHead .val){
                return false;
            }
            A = A.next;
            newHead = newHead.next;
        }
        return true;
    }



//给定两个链表 判断 链表是否相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //1.首先得到两个链表的长度  并取得差值
        int sizeA = this.getListSize(headA);
        int sizeB = this.getListSize(headB);
        int different = Math.abs(sizeA - sizeB) ; //取得差值的绝对值
        //2.让长度较长的链表先开始遍历 直到长度与另外的链表长度相等
        if (sizeA > sizeB){
            for (int i = 0; i<different;i++){
                headA = headA.next;
            }
        }else if(sizeA <sizeB){
            for (int i = 0; i<different;i++){
                headB = headB.next;
            }
        }
        //3.同时遍历两个链表 并比较两个链表的元素引用
        while(headA != null){
            if(headA == headB){  //若两个节点引用的hash值相等 说明有交点
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }


    //给定一个链表 判断链表是否有环
        //核心  快慢指针  让差值为1
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;  //快指针
        ListNode slow = head;   //慢指针
        while (fast!= null&&fast.next != null){ //注意 空指针异常
            slow = slow.next;  //slow 走一步
            fast = fast.next.next; //fast 走两步
            if(fast == slow){  //若引用相等 说明有环
                return true;
            }
        }
        return false;
    }
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    //若链表有环 那么fast和 slow 相交的位置到入环第一个节点距离 与 头结点到入环的第一个节点的距离 相等
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){  //说明有环
                ListNode cur = head; //创建一个新节点 从头开始
                while(slow != cur){//另一个节点从 相交点开始 当两个节点重合就是环的第一个节点
                    slow = slow.next;
                    cur = cur.next;
                }
                return cur;
            }
        }
        return null;
    }

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            if (pa != null) {
                pa = pa.next;
            }else{
                pa = headB;
            }
            if (pb != null) {
                pb = pb.next;
            }else{
                pb = headA;
            }
        }
        if (pa ==null) {
            return null;
        }
        return pa;
    }


    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(6);
        a.next= b;
        b.next =c;
        //c.next = d;
        d.next =e;
        e.next = f;
        Test t= new Test();
        ListNode result = t.mergeTwoLists(a,d);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}

