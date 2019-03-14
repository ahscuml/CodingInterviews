package question;

import java.util.Scanner;

/**
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author ahscuml
 * @date 2018/8/16
 * @time 15:34
 */
public class Q10RectCover {
    /**
     * 类比青蛙跳台阶问题，一次竖着摆一个或者一次横着摆两个
     * */
    public static int RectCover(int target) {
        if(target <= 0)
            return 0;
        int front = 2, back = 1;
        while (target-- > 1) {
            front += back;
            back = front - back;
        }
        return back;
    }

    /**
     * 测试用例
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int n = in.nextInt();
        System.out.println("覆盖2 * " + n + "的矩形有 " + RectCover(n) + " 种方法");
    }
}
