package question;

import java.util.Scanner;

/**
 * 青蛙跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @author ahscuml
 * @date 2018/8/16
 * @time 11:35
 */
public class Question10_JumpFloor {
    /**
     * 这道题的思路是，青蛙到达最后一个台阶有两种选择，一步或者两步，在到达倒数第二个台阶也有两个选择，一步或者两步
     * 所以问题就变得很简单，动态规划的思想，递归的思路,自上而下循环的写法
     */
    public static int jumpFloor(int target) {
        int front = 2, next = 1;
        if (target <= 0) {
            return 0;
        }
        while (target-- > 1) {
            front += next;
            next = front - next;
        }
        return next;
    }

    /**
     * 测试代码
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int n = in.nextInt();
        System.out.println("爬 " + n + " 级台阶有 " + jumpFloor(n) + " 种方法");
    }
}
