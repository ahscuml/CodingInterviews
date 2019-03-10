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
        // 如果头结点为空
        if (head == null) {
            return head;
        }
        // 遍历过程中总共需要三个节点，分别是head，tail，cur
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
