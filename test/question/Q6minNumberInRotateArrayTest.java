package question;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author ahscuml
 * @date 2019/3/12
 * @time 19:17
 */
public class Q6minNumberInRotateArrayTest {
    @Test
    public void minNumberInRotateArrayTest() {
        Q6minNumberInRotateArray q6 = new Q6minNumberInRotateArray();
        int[] array = {1,1,1,1,1};
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {0};
        int[] array3 = {1};
        int[] array4 = {6,8,9,11,45,2,4,5};
        Assert.assertEquals(q6.minNumberInRotateArray(array), 1);
        Assert.assertEquals(q6.minNumberInRotateArray(array1), 1);
        Assert.assertEquals(q6.minNumberInRotateArray(array2), 0);
        Assert.assertEquals(q6.minNumberInRotateArray(array3), 1);
        Assert.assertEquals(q6.minNumberInRotateArray(array4), 2);
    }
}
