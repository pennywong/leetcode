import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/permutations-ii/
 * <p/>
 * Created by Penny on 2015/01/21
 */
public class PermutationsII {
    /**
     * 参考：http://www.programcreek.com/2013/02/leetcode-permutations-ii-java/
     */
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (num != null && num.length > 0)
            permute(num, 0, result);

        return result;
    }

    private void permute(int[] num, int index, List<List<Integer>> result) {
        if (index == num.length) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < num.length; i++)
                list.add(num[i]);
            result.add(list);
        } else {
            Set<Integer> set = new HashSet<Integer>();
            for (int i = index; i < num.length; i++) {
                if (set.contains(num[i]) == false) {
                    set.add(num[i]);
                    swap(num, index, i);
                    permute(num, index + 1, result);
                    swap(num, i, index);
                }
            }
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
