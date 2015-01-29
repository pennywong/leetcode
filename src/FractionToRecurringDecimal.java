import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/fraction-to-recurring-decimal/
 * <p/>
 * Created by Penny on 2015/01/28
 */
public class FractionToRecurringDecimal {
    /**
     * http://blog.csdn.net/ljiabin/article/details/42025037
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        if (denominator == 0)
            return "";

        StringBuilder stringBuilder = new StringBuilder();

        if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0)
            stringBuilder.append("-");

        long num = (long) numerator;
        long den = (long) denominator;

        num = Math.abs(num);
        den = Math.abs(den);

        stringBuilder.append(num / den);

        long rem = (num % den) * 10;
        if (rem != 0)
            stringBuilder.append(".");

        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while (rem != 0) {
            if (map.containsKey(rem)) {
                int index = map.get(rem);
                stringBuilder.insert(index, "(");
                stringBuilder.append(")");
                break;
            }

            map.put(rem, stringBuilder.length());
            stringBuilder.append(rem / den);
            rem = (rem % den) * 10;
        }

        return stringBuilder.toString();
    }
}
