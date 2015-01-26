import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/combination-sum-ii/
 * <p/>
 * Created by Penny on 2015/01/20
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);

        List<List<Integer>> result = new LinkedList<List<Integer>>();

        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;

            List<Integer> list = new LinkedList<Integer>();
            list.add(0);
            sum(num, i, target, result, list);
        }

        return result;
    }

    private void sum(int[] num, int index, int target, List<List<Integer>> result, List<Integer> list) {
        int sum = list.get(0) + num[index];

        if (sum > target)
            return;

        list.set(0, sum);
        list.add(num[index]);

        if (sum == target) {
            list.remove(0);
            result.add(list);
            return;
        }

        for (int i = index + 1; i < num.length; i++) {
            if (i > (index + 1) && num[i] == num[i - 1])
                continue;
            List<Integer> temp = new LinkedList<Integer>(list);
            sum(num, i, target, result, temp);
        }
    }
}
