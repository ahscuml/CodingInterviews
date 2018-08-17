import java.util.Scanner;

/**
 * 斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * @author ahscuml
 * @date 2018/8/16
 * @time 10:36
 */
public class Question10_Fib {
    /**
     * 递归的写法，简单易懂，但是计算重复，占用空间大
     */
    public static int fibonacci_Cyc(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fibonacci_Cyc(n - 1) + fibonacci_Cyc(n - 2);
    }

    /**
     * 相比较于递归的写法，利用循环可以避免不必要的计算和存储空间
     */
    public static int fibonacci_Rec(int n) {
        if (n <= 0) {
            return 0;
        }
        int n_1 = 1, n_2 = 0;
        // 自减操作符会先进行判断，再减。 只用两个变量就完成了替换（巧妙）
        // 重点是循环条件以及返回结果的选择！！！
        while (n-- > 0) {
            n_1 += n_2;
            n_2 = n_1 - n_2;
        }
        return n_2;
    }

    /**
     * 同样的问题还有一种 O(logn)的解法，利用数组，不够实用，就不贴了
     * */

    /**
     * 测试函数
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int n = in.nextInt();
        System.out.println("Fibonacci第 " + n + " 项是：" + fibonacci_Rec(n));
        System.out.println("Fibonacci第 " + n + " 项是：" + fibonacci_Cyc(n));
    }
}
