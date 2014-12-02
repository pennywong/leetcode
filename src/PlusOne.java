/**
 * https://oj.leetcode.com/problems/plus-one/
 * <p/>
 * Created by Penny on 2014/11/25
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;

        int[] a = new int[digits.length];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int x = digits[i] + carry;
            if (x >= 10) {
                a[i] = x - 10;
                carry = 1;
            } else {
                a[i] = x;
                carry = 0;
            }
        }

        if (carry == 1) {
            int[] b = new int[a.length + 1];
            for (int i = 0; i < a.length; i++)
                b[i + 1] = a[i];
            b[0] = 1;
            a = b;
        }

        return a;
    }
}
