/**
 * https://oj.leetcode.com/problems/powx-n/
 * <p/>
 * Created by Penny on 2014/12/10
 */
public class Pow {
    /**
     * 参考了本题的讨论
     */
    public double pow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = 1;
        while (n > 0) {
            if (n % 2 == 1)
                result *= x;

            x = x * x;
            n /= 2;
        }

        return result;
    }
}
