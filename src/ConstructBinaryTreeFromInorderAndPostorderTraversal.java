/**
 * https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * <p/>
 * Created by Penny on 2015/01/26
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    /**
     * 参考：http://blog.unieagle.net/2012/12/12/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Aconstruct-binary-tree-from-inorder-and-postorder-traversal/?utm_source=tuicool
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (ie - is < 0 || ie - is != pe - ps)
            return null;

        TreeNode root = new TreeNode(postorder[pe]);
        int i = is;
        while (i <= ie && inorder[i] != root.val)
            i++;
        if (i <= ie) {
            int leftcount = i - is;
            root.left = buildTree(inorder, is, i - 1, postorder, ps, ps + leftcount - 1);
            root.right = buildTree(inorder, i + 1, ie, postorder, ps + leftcount, pe - 1);
        }

        return root;
    }
}
