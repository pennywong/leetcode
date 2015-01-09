import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 * <p/>
 * Created by Penny on 2015/01/09
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        sum(root, 0, list);
        return list.get(0);
    }

    private void sum(TreeNode root, int sum, List<Integer> list) {
        if (root == null)
            return;

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            list.set(0, list.get(0) + sum);
            return;
        }

        if (root.left != null)
            sum(root.left, sum, list);

        if (root.right != null)
            sum(root.right, sum, list);
    }
}
