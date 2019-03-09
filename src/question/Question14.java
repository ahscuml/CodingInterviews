package question;

/**
 * 剪绳子
 * 给定一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],…,k[m]。
 * 请问k[0]* k[1] * … *k[m]可能的最大乘积是多少？
 *
 * 动态规划的四个特点
 * 1. 问题是求最优解；
 * 2. 整体的问题的最优解是依赖各个子问题的最优解；
 * 3. 子问题之间还有互相重叠的更小的子问题；
 * 4. 为避免子问题的重复计算，我们存储子问题的最优解。从上往下分析问题，从下往上求解问题。
 * @author ahscuml
 * @date 2018/9/12
 * @time 11:25
 */
public class Question14 {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        System.out.println(cutRope(8));
    }

    public static int cutRope(int length) {
        if (length < 2){
            return 0;
        } else if (length == 2) {
            return 1;
        } else if(length == 3) {
            return 2;
        } else {
            // f是把长度为i的元素剪成若干段乘积的最大值
            int[] f = new int[length + 1];
            f[0] = 0;
            f[1] = 1;
            f[2] = 2;
            f[3] = 3;
            int result = 0;
            for (int i = 4; i <= length; i++) {
                int max = 0;
                for (int j = 1; j <= i / 2; j++) {
                    int num = f[j] * f[i - j];
                    if (max < num) {
                        max = num;
                    }
                    f[i] = max;
                }
            }
            result = f[length];
            return result;
        }


    }
}
