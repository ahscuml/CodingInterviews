/**
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @author ahscuml
 * @date 2018/9/19
 * @time 18:25
 */
public class Question15 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(0));
        System.out.println(NumberOf1(4));
        System.out.println(NumberOf1(7));
    }

    /*public static int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }*/

    public static int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
