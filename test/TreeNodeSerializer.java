import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Penny on 2014/11/24
 */
public class TreeNodeSerializer {
    public static TreeNode toTree(String str) {
        if (str == null)
            return null;

        String[] strs = str.split(",");
        return toTree(strs);
    }

    public static TreeNode toTree(String[] strs) {
        if (strs == null || strs.length == 0)
            return null;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        int index = 0;
        TreeNode root = addNode(queue, strs[0]);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            index++;
            if (index == strs.length)
                break;
            TreeNode left = addNode(queue, strs[index]);
            node.left = left;

            index++;
            if (index == strs.length)
                break;
            TreeNode right = addNode(queue, strs[index]);
            node.right = right;
        }

        return root;
    }

    private static TreeNode addNode(Queue<TreeNode> queue, String str) {
        if (str.equals("#"))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.parseInt(str));
            queue.add(node);
            return node;
        }
    }

    public static void output(TreeNode root) {
        printTree(root, 0);
    }

    private static void printTree(TreeNode node, int indent) {
        if (node == null)
            return;

        printTree(node.right, indent + 1);
        printNode(node, indent);
        printTree(node.left, indent + 1);
    }

    private static void printNode(TreeNode node, int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("\t");
        }
        sb.append(node.val);
        System.out.println(sb.toString());
    }
}
