package question;

/**
 * @author ahscuml
 * @date 2019/4/6
 * @time 20:35
 */
public class cutRope {
    public static void main(String[] args) {
        System.out.println(cutRope(8));
        System.out.println(cutRopeII(8));
    }

    /**
     * 典型的DP问题，求最大的乘积。
     * 首先找到子问题
     * 然后通过子问题找出关系式(自底向上计算)
     * 然后创建辅助的数组，空间换时间的想法，存储之前计算的值
     */
    public static int cutRope(int n) {
        if (n == 0 || n == 1 || n == 2 || n == 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(j * (i - j), Math.max(dp[i - j] * dp[j], dp[i]));
                if (dp[i] < i) {
                    dp[i] = i;
                }
            }
            System.out.print(dp[i] + " ");
        }
        return dp[n];
    }

    /**
     * 贪心算法：
     * 当n = 4时，最大乘积就是4.
     * 当n >= 5时，尽可能多剪长度为3的绳子，当剩下为4的时候，就剪成两段2
     * 也就是说，n>=5时，最大乘积都由若干个3，最多两个2构成的
     * 证明很简单:
     * n >= 5时，3(n-3) >= 2(n-2) > n
     */
    public static int cutRopeII(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int count3 = n / 3;
        // 如果最后剩下4不能裁成3，因为4 > 3;
        if (n - count3 * 3 == 1) {
            count3 -= 1;
        }
        // 裁成2 * 2；
        int count2 = (n - count3 * 3) / 2;
        return (int) (Math.pow(3, count3)) * (int) (Math.pow(2, count2));
    }
}
