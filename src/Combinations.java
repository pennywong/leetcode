import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/combinations/
 * <p/>
 * Created by Penny on 2015/01/08
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (n <= 0 || k <= 0 || n < k)
            return result;

        combine(n, k, 0, result, new LinkedList<Integer>());

        return result;
    }

    public void combine(int n, int k, int index, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == k) {
            result.add(list);
            return;
        }

        for (int i = index + 1; i <= n; i++) {
            List<Integer> nextList = new ArrayList<Integer>(list);
            nextList.add(i);
            combine(n, k, i, result, nextList);
        }
    }
}
