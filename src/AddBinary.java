/**
 * Created by Penny on 2014/11/25
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null)
            return b;

        if (b == null)
            return a;

        StringBuilder stringBuilder = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        for (; i >= 0 || j >= 0; i--, j--) {
            int x = i < 0 ? 0 : a.charAt(i) - '0';
            int y = j < 0 ? 0 : b.charAt(j) - '0';

            carry = add(x, y, carry, stringBuilder);
        }

        if (carry == 1)
            stringBuilder.insert(0, "1");

        return stringBuilder.toString();
    }

    private int add(int x, int y, int carry, StringBuilder stringBuilder) {
        int sum = x + y + carry;

        if (sum == 0 || sum == 2)
            stringBuilder.insert(0, "0");
        else
            stringBuilder.insert(0, "1");

        if (sum < 2)
            carry = 0;
        else
            carry = 1;

        return carry;
    }
}
