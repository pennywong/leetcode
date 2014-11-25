import org.junit.Test;

/**
 * Created by Penny on 2014/11/24
 */
public class TreeTest {
    @Test
    public void test() {
        String string = "1,2,2,3,#,#,3,4,#,#,4";
        TreeNode root = TreeNodeSerializer.toTree(string);
        TreeNodeSerializer.output(root);
    }
}
