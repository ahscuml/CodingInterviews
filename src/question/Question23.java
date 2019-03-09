package question;

import util.ListNode;

/**
 * 将一个链表倒过来
 *
 * @author ahscuml
 * @date 2019/3/10
 * @time 0:16
 */
public class Question23 {

    /**
     * 还是要注意最后一个节点要赋值为null
     */
    public ListNode ReverseList(ListNode head) {
        // 如果只有一个节点，或者只有两个节点
        if (head == null) {
            return head;
        }

        ListNode cur = head.next;
        ListNode tail = head;
        // ABCD -> BACD -> CBAD -> DCBA
        while (cur != null) {
            tail.next = cur.next;
            cur.next = head;
            head = cur;
            cur = tail.next;
        }
        return head;
    }
}
