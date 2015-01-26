import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/n-queens/
 * <p/>
 * Created by Penny on 2015/01/21
 */
public class NQueens {
    /**
     * 参考：http://www.cnblogs.com/longhorn/p/3518868.html
     */
    public List<String[]> solveNQueens(int n) {
        int[] a = new int[n];
        List<String[]> list = new LinkedList<String[]>();
        solveNQueens(a, 0, list);
        return list;
    }

    private void solveNQueens(int[] a, int index, List<String[]> list) {
        if (index == a.length) {
            list.add(print(a));
        } else {
            for (int i = 0; i < a.length; i++) {
                a[index] = i;
                if (isValid(a, index))
                    solveNQueens(a, index + 1, list);
            }
        }
    }

    private String[] print(int[] a) {
        String[] strings = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < a.length; j++) {
                if (a[i] == j)
                    stringBuilder.append("Q");
                else
                    stringBuilder.append(".");
            }
            strings[i] = stringBuilder.toString();
        }

        return strings;
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
