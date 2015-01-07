/**
 * https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * <p/>
 * Created by Penny on 2014/12/10
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0)
            return null;

        return convert(num, 0, num.length - 1);
    }

    private TreeNode convert(int[] num, int start, int end) {
        if (start < 0 || start >= num.length || end < 0 || end >= num.length || start > end)
            return null;

        if (start == end)
            return new TreeNode(num[start]);

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = convert(num, start, mid - 1);
        root.right = convert(num, mid + 1, end);

        return root;
    }
}
