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
        if (head == null) {
            // 空链表, 没的删
            return null;
        }
        // 1. 先删除中间节点的情况(非头部的情况)
        ListNode prev = head;  // prev 始终指向 cur 的前一个位置
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                // 这个节点就需要删除掉
                prev.next = cur.next; // 这一行代码下来, cur 对应的节点就被删掉了
                cur = prev.next;        // cur 指向下一个元素, 方便进行下次循环
            } else {
                // 这个节点不需要删除
                prev = cur;
                cur = cur.next;
            }
        }
        // 2. 最后再考虑删除头结点的情况(放到最后, 只需要处理一次即可)
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    }
}
