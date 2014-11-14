/**
 * https://oj.leetcode.com/problems/palindrome-number/
 * <p/>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p/>
 * Some hints: Could negative integers be palindromes? (ie, -1)
 * <p/>
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * <p/>
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * <p/>
 * There is a more generic way of solving this problem.
 *
 * @author Penny on 2014/11/07
 */
public class PalindromeNumber {
    /**
     * 回文就是数字对称的数字，如：121, 1221, 1234321
     * <p/>
     * 判断一个数字是否回文，只需把该数字倒转，如果等于本身则是回文数字
     * <p/>
     * 因为不能使用额外的空间，则不能先转成字符串
     * <p/>
     * 可以使用余数左移的方式来倒转数字
     */
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int t = x;

        int z = 0;
        while (t != 0) {
            int y = t % 10;
            t = t / 10;
            z = z * 10 + y;
        }

        return z == x;
    }
}
