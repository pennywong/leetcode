import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/combination-sum/
 * <p/>
 * Created by Penny on 17/1/15.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new LinkedList<List<Integer>>();

        for (int i = 0; i < candidates.length; i++) {
            List<Integer> list = new LinkedList<Integer>();
            list.add(0);
            sum(candidates, i, target, result, list);
        }

        return result;
    }

    private void sum(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> list) {
        list.set(0, list.get(0) + candidates[index]);
        list.add(candidates[index]);

        if (list.get(0) > target)
            return;

        if (list.get(0) == target) {
            list.remove(0);
            result.add(list);
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            List<Integer> temp = new LinkedList<Integer>(list);
            sum(candidates, i, target, result, temp);
        }
    }
}
