package list;

public class Test {
    public class ListNode {
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
        if (head == null) {
            // 空链表, 不需要逆置
            return null;
        }
        if (head.next == null) {
            // 链表中只有一个元素, 也不需要逆置
            return head;
        }
        ListNode newHead = null;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                // 当前 cur 就是原链表的末尾
                newHead = cur;
            }
            // 逆置的核心操作
            cur.next = prev;
            // 更新三兄弟的指向位置
            prev = cur;
            cur = next;
        }
        return newHead;
    }
}

