/**
 * https://oj.leetcode.com/problems/multiply-strings/
 * <p/>
 * Created by Penny on 2014/12/17
 */
public class MultiplyStrings {
    /**
     * 完全按照乘法来做，中间可以简化
     */
    public String multiply(String num1, String num2) {
        String result = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            char c = num1.charAt(i);
            String string = multiply(c, num2, num1.length() - i - 1);

            result = add(result, string);
        }

        if (result.startsWith("0")) {
            StringBuilder stringBuilder = new StringBuilder(result);
            stringBuilder.append(result);
            while (stringBuilder.charAt(0) == '0' && stringBuilder.length() > 1) {
                stringBuilder.deleteCharAt(0);
            }

            result = stringBuilder.toString();
        }

        return result;
    }

    private String multiply(char c, String num, int digit) {
        int carry = 0;
        int x = Character.digit(c, 10);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            int y = x * Character.digit(num.charAt(i), 10) + carry;
            stringBuilder.append(y % 10);
            carry = y / 10;
        }

        if (carry > 0)
            stringBuilder.append(carry);

        stringBuilder.reverse();
        for (int i = 0; i < digit; i++)
            stringBuilder.append("0");

        return stringBuilder.toString();
    }

    private String add(String a, String b) {
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int x = i >= 0 ? Character.digit(a.charAt(i), 10) : 0;
            int y = j >= 0 ? Character.digit(b.charAt(j), 10) : 0;
            int z = x + y + carry;
            stringBuilder.append(z % 10);
            carry = z / 10;
        }

        if (carry > 0)
            stringBuilder.append(carry);

        return stringBuilder.reverse().toString();
    }
}
