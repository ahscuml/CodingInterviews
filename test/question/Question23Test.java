package question;

import org.junit.Assert;
import org.junit.Test;
import util.ListNode;

/**
 * @author ahscuml
 * @date 2019/3/10
 * @time 0:29
 */
public class Question23Test {
    @Test
    public void ReversListTest() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        Question23 question23 = new Question23();
        Assert.assertEquals(question23.ReverseList(listNode1), listNode4);
    }
}
