/**
 * https://oj.leetcode.com/problems/find-peak-element/
 * <p/>
 * Created by Penny on 2014/12/10
 */
public class FindPeakElement {
    public int findPeakElement(int[] num) {
        int n = num.length;

        if (n <= 1)
            return 0;

        if (num[0] > num[1])
            return 0;

        if (num[n - 1] > num[n - 2])
            return n - 1;

        for (int i = 1; i < n - 1; i++) {
            if (num[i] > num[i - 1] && num[i] > num[i + 1])
                return i;
        }

        return -1;
    }
}
