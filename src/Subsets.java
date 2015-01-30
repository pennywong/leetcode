import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/subsets/
 * <p/>
 * Created by Penny on 17/1/15.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);

        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i = 0; i < S.length; i++) {
            subset(result, S[i]);
        }
        result.add(new ArrayList<Integer>());

        return result;
    }

    private void subset(List<List<Integer>> result, int num) {
        int len = result.size();
        for (int i = 0; i < len; i++) {
            List list = new LinkedList();
            list.addAll(result.get(i));
            list.add(num);
            result.add(list);
        }

        List<Integer> list = new LinkedList<Integer>();
        list.add(num);
        result.add(list);
    }
}
