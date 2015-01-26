/**
 * https://oj.leetcode.com/problems/n-queens-ii/
 * <p/>
 * Created by Penny on 2015/01/21
 */
public class NQueensII {
    public int totalNQueens(int n) {
        int[] a = new int[n];
        return totalNQueens(a, 0);
    }

    private int totalNQueens(int[] a, int index) {
        if (index == a.length)
            return 1;

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            a[index] = i;
            if (isValid(a, index))
                sum += totalNQueens(a, index + 1);
        }

        return sum;
    }

    private boolean isValid(int[] a, int index) {
        for (int i = 0; i < index; i++) {
            if (a[i] == a[index])
                return false;
            if (Math.abs(a[i] - a[index]) == Math.abs(i - index))
                return false;
        }

        return true;
    }
}
