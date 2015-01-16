/**
 * https://oj.leetcode.com/problems/divide-two-integers/
 * <p/>
 * Created by Penny on 2015/01/16
 */
public class DivideTwoIntegers {
    /**
     * 参考：http://www.cnblogs.com/lihaozy/archive/2012/12/30/2840070.html
     */
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;

        if (divisor == 0)
            return 0;

        boolean flag = false;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
            flag = true;

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long result = 0;
        while (a >= b) {
            long count = 1;
            long sum = b;
            while ((sum + sum) <= a) {
                sum += sum;
                count += count;
            }
            a -= sum;
            result += count;
        }

        if (flag)
            result = -result;

        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int) result;
    }
}
