import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/subsets-ii/
 * <p/>
 * Created by Penny on 17/1/15.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (num.length == 0)
            return result;

        List<Integer> list = new LinkedList<Integer>();
        list.add(num[0]);
        result.add(list);

        int index = 0;
        int current = 1;
        for (int i = 1; i < num.length; i++) {
            subset(result, num[i - 1], num[i], index);
            index = current;
            current = result.size();
        }
        result.add(new ArrayList<Integer>());

        return result;
    }

    private void subset(List<List<Integer>> result, int pre, int num, int index) {
        int len = result.size();
        int start = 0;
        if (pre == num)
            start = index;

        for (int i = start; i < len; i++) {
            List list = new LinkedList();
            list.addAll(result.get(i));
            list.add(num);
            result.add(list);
        }

        if (pre != num) {
            List<Integer> list = new LinkedList<Integer>();
            list.add(num);
            result.add(list);
        }
    }
}
