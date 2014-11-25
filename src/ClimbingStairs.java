/**
 * https://oj.leetcode.com/problems/climbing-stairs/
 * <p/>
 * Created by Penny on 2014/11/25
 */
public class ClimbingStairs {
    /**
     * F(n) = F(n-2) + F(n-1) n>=3
     * <p/>
     * 使用一个数组记录已经计算过的数，减少运行时间
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 0)
            return 0;

        int[] a = new int[n + 1];

        return climb(a, n);
    }

    private int climb(int[] a, int n) {
        if (n == 1)
            return 1;

        if (n == 2)
            return 2;

        if (a[n] == 0)
            a[n] = climb(a, n - 2) + climb(a, n - 1);

        return a[n];
    }
}
