/**
 * @author ahscuml
 * @date 2018/12/8
 * @time 16:52
 */
public class Question18II {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        ListNode res = deleteDuplication(listNode1);
        while (res != null) {
            System.out.print(res.val + ", ");
            res = res.next;
        }
    }

    /**
     * 主函数
     * 这道题的重点就是如何删除重复的元素。
     */
    public static ListNode deleteDuplication(ListNode head) {
        // 返回的是head
        // cur是用来遍历整个链表的，pre是为了连接新链表的
        ListNode pre = null;
        ListNode cur = head;
        // 从头到尾遍历整个链表
        while (cur != null) {
            // curnext是cur将要指向的节点
             ListNode curnext = cur.next;
             boolean needDelete = false;
             // 后一个节点与前一个节点值相同，则当前节点需要删除
             if(curnext != null && curnext.val == cur.val) {
                 needDelete = true;
             }

             // 如果不需要删除，则pre向后移动，cur向后移动
             if (!needDelete) {
                 pre = cur;
                 cur = cur.next;
             } else {
                 // 如果需要删除
                 // 首先存储重复元素的数值
                 int val = cur.val;
                 // 存储即将被删除的节点
                 ListNode toBeDel = cur;
                 // 删除所有值为val的元素
                 while (toBeDel != null && toBeDel.val == val) {
                     curnext = toBeDel.next;
                     toBeDel = curnext;
                     // 程序运行到这里，next与toBeDel指向同一个节点
                 }
                 // 如果删除的是头结点
                 if(pre == null) {
                     head = curnext;
                 } else {
                     pre.next = curnext;
                 }
                 cur = curnext;
             }
        }
        return head;
    }

    /**
     * 链表结构
     */
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
