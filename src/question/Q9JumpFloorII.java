package question;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author ahscuml
 * @date 2018/8/16
 * @time 15:31
 */
public class Q9JumpFloorII {
    /**
     * 归纳法，最终f(n) = 2^n-1
     * */
    public static int jumpFloorII(int target) {
        return (int)Math.pow(2, target - 1);
    }
}
