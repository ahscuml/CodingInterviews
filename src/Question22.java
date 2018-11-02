/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 与Leetcode第19题类似
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * @author ahscuml
 * @date 2018/11/2
 * @time 9:39
 */
public class Question22 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(FindKthToTail(listNode1, 2).val);;

    }
    public static ListNode FindKthToTail(ListNode head,int k) {
        ListNode right = new ListNode(0);
        right.next = head;
        ListNode left = right;
        while(k > 0) {
            if(right.next == null){
                return null;
            }
            right = right.next;
            k--;
        }
        while(right.next != null) {
            right = right.next;
            left = left.next;
        }
        return left.next;
    }

    /**
     * 链表的定义
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
