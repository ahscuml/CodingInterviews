package question;

/**
 * 二进制中1的个数
 * @author ahscuml
 * @date 2019/3/14
 * @time 21:22
 */
public class Q11NumberOf1 {
    public static void main(String[] args) {

    }

    /**
     * 简单的思路就是让1从最后一位开始，向前遍历，并与那一位相与，看看结果就知道是不是1
     * */
    public void static int NumberOf1(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n = (n - 1) & n;
        }
        return res;
    }
}
