import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/path-sum-ii/
 * <p/>
 * Created by Penny on 2014/12/05
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null)
            return result;

        sum -= root.val;

        if (root.left == null && root.right == null && sum == 0) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(root.val);
            result.add(list);
        }

        if (root.left != null) {
            List<List<Integer>> left = pathSum(root.left, sum);
            if (!left.isEmpty()) {
                for (List<Integer> list : left)
                    list.add(0, root.val);
                result.addAll(left);
            }
        }

        if (root.right != null) {
            List<List<Integer>> right = pathSum(root.right, sum);
            if (!right.isEmpty()) {
                for (List<Integer> list : right)
                    list.add(0, root.val);
                result.addAll(right);
            }
        }

        return result;
    }
}
