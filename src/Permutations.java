import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/permutations/
 * <p/>
 * Created by Penny on 2014/12/17
 */
public class Permutations {
    /**
     * 参考：http://blog.csdn.net/worldwindjp/article/details/21485797
     */
    public List<List<Integer>> permute(int[] num) {
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
            for (int i = index; i < num.length; i++) {
                swap(num, index, i);
                permute(num, index + 1, result);
                swap(num, i, index);
            }
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
