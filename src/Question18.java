/**
 * @author ahscuml
 * @date 2018/12/8
 * @time 15:54
 */
public class Question18 {
    /**
     * 测试函数
     * */
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
     *
     * */
    public static ListNode deleteDuplication(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = null;
        ListNode confirmed = dummyHead;
        // cur是当前遍历的节点，left是cur的左节点，right是cur的右节点
        ListNode left = null,cur = head,right = null;
        // 结束条件的判断,关系着右节点的赋值位置
        while(cur != null) {
            right = cur.next;
            // 最开始左节点为空
            if(!dup(left,cur,right)) {
                confirmed.next = cur;
                confirmed = confirmed.next;
            }
            left = cur;
            cur = cur.next;
        }
        confirmed.next = null;
        return dummyHead.next;
    }


    /**
     *  判断当前节点是否重复的函数
     *  最关键的问题是如何判断一个节点是否重复？？？
     *  当前节点的前一个节点的值与后一个节点的值都与当前节点的值不相同，同时还要考虑到头节点和尾节点的问题
     * */
    private static boolean dup(ListNode left,ListNode cur, ListNode right) {
        if(left == null || right == null) {
            if(left == null) {
                if(right != null) {
                    if(cur.val == right.val) {
                        return true;
                    }
                }
            }
            else if(right == null) {
                if(left.val == cur.val) {
                    return true;
                }
            }
        } else if (left.val == cur.val || right.val == cur.val) {
            return true;
        }
        return false;
    }

    /**
     * 链表结构
     * */
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
