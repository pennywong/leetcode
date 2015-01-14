/**
 * https://oj.leetcode.com/problems/largest-number/
 * <p/>
 * Created by Penny on 2015/01/13
 */
public class LargestNumber {
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0)
            return "";

        int[] result = new int[num.length];
        result[0] = num[0];
        for (int i = 1; i < num.length; i++) {
            int j = i - 1;
            while (j >= 0 && isBigger(num[i], result[j])) {
                result[j + 1] = result[j];
                j--;
            }
            result[j + 1] = num[i];
        }

        int i = 0;
        while (i < result.length - 1 && result[i] == 0) {
            i++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (; i < result.length; i++)
            stringBuilder.append(result[i]);

        return stringBuilder.toString();
    }

    private boolean isBigger(int x, int y) {
        String a = Integer.toString(x) + Integer.toString(y);
        String b = Integer.toString(y) + Integer.toString(x);

        for (int i = 0; i < a.length(); i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (c1 > c2)
                return true;

            if (c1 < c2)
                return false;
        }

        return false;
    }
}
