package question;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * @author ahscuml
 * @date 2019/3/12
 * @time 19:35
 */
public class Q7FibonacciTest {
    @Test
    public void FibonacciTest() {
        Q7Fibonacci fb = new Q7Fibonacci();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(39) + 1;
            Assert.assertEquals(fb.fibonacci_Cyc(num), fb.fibonacci_Rec(num));
        }
    }
}
