/**
 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 * <p/>
 * Created by Penny on 2015/01/13
 */
public class FactorialTrailingZeroes {
    /**
     * 参考：http://blog.csdn.net/doc_sgl/article/details/42344441, http://blog.csdn.net/xudli/article/details/42262153
     */
    public int trailingZeroes(int n) {
        int sum = 0;
        while (n != 0) {
            int x = n / 5;
            sum += x;
            n = x;
        }
        return sum;
    }
}
