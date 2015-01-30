import java.util.LinkedList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 * <p/>
 * Created by Penny on 24/1/15.
 */
public class UniqueBinarySearchTreesII {
    /**
     * 参考：http://www.cnblogs.com/x1957/p/3521372.html
     */
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int l, int r) {
        List<TreeNode> list = new LinkedList<TreeNode>();
        if (l > r) {
            list.add(null);
        } else {
            for (int i = l; i <= r; i++) {
                List<TreeNode> left = generate(l, i - 1);
                List<TreeNode> right = generate(i + 1, r);
                for (int m = 0; m < left.size(); m++) {
                    for (int n = 0; n < right.size(); n++) {
                        TreeNode node = new TreeNode(i);
                        node.left = left.get(m);
                        node.right = right.get(n);
                        list.add(node);
                    }
                }
            }
        }
        return list;
    }
}
