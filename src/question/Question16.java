package question;

/**
 * 数值整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * @author ahscuml
 * @date 2018/9/19
 * @time 18:55
 */
public class Question16 {
    public static void main(String[] args) {
        System.out.println(Power(5, 6));
    }

    /**
     * 简单地思路就是采用循环，判断exponent的正负，分别计算，同时还要注意到base为0，exponent为负数的时候，需要特殊考虑
     * */
    /*public double Power(double base, int exponent) {
        double  result=1;
        for(int i=0;i<Math.abs(exponent);i++){
            result*=base;
        }
        if(exponent<0){
            result=1/result;
        }
        return result;
    }*/

    /**
     * 优化时间复杂度，递归，O(nlogn)
     * 利用右移代替除2
     * 利用与1进行与运算判断是否是偶数
     */
    public static double Power(double base, int exponent) {
        int n = Math.abs(exponent);
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        double result = Power(base, n >> 1);
        result *= result;
        if ((n & 1) == 1)
            result *= base;
        if (exponent < 0){
            result = 1 / result;
        }
        return result;
    }
}
