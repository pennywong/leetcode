/**
 * https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p/>
 * Created by Penny on 2015/01/26
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     * 参考：http://blog.unieagle.net/2012/12/11/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Aconstruct-binary-tree-from-preorder-and-inorder-traversal/?utm_source=tuicool&replytocom=24738
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (pe - ps < 0 || pe - ps != ie - is)
            return null;

        TreeNode root = new TreeNode(preorder[ps]);
        int i = is;
        while (i <= ie && inorder[i] != root.val)
            i++;

        if (i <= ie) {
            int leftcount = i - is;
            root.left = buildTree(preorder, ps + 1, ps + leftcount, inorder, is, i - 1);
            root.right = buildTree(preorder, ps + leftcount + 1, pe, inorder, i + 1, ie);
        }

        return root;
    }
}
