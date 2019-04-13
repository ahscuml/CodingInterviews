package question;

import util.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从头到尾打印链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * @author ahscuml
 * @date 2018/8/13
 * @time 9:19
 */


public class Q3printListFromTailToHead {
    /**
     * 链表考虑到递归调用
     * 递归调用的写法也很关键
     * 使用递归，空间开销会很大吧？？？？ 递归的讨论 存储的一些内容，看看虚拟机
     * TODO 这个递归的方法还可以再研究研究
     */
    private static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ListNode pNode = listNode;
        if (pNode != null) {
            if (pNode.next != null) {
                arrayList = printListFromTailToHead(pNode.next);
            }
            arrayList.add(pNode.val);
        }
        return arrayList;
    }

    /**
     * 由于是从后向前打印，“后进先出”的思路，所以采用栈的思路
     */
    private static ArrayList<Integer> printListFromTailToHead_Stack(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    /**
     * 测试代码
     * 链表的创建
     */
    public static void main(String[] args) {
        // 构造测试用例
        ListNode head, tail;
        head = new ListNode(1);
        tail = head;
        for (int i = 2; i < 10; i++) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        System.out.println(printListFromTailToHead_Stack(head));
        System.out.println(printListFromTailToHead(head));
    }
}

