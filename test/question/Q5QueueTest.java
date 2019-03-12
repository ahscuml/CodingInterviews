package question;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ahscuml
 * @date 2019/3/12
 * @time 18:54
 */
public class Q5QueueTest {
    @Test
    public void pop() {
        Q5Queue q5Queue = new Q5Queue();
        Queue queue = new LinkedList();

        q5Queue.push(5);
        ((LinkedList) queue).push(5);

        Assert.assertEquals(q5Queue.pop(),((LinkedList) queue).pop());
    }

    @Test
    public void push() {

    }
}
