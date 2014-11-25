import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Penny on 2014/11/25
 */
@RunWith(Parameterized.class)
public class BalancedBinaryTreeTest {
    private boolean expect;
    private String string;

    public BalancedBinaryTreeTest(boolean expect, String string) {
        this.expect = expect;
        this.string = string;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameter() {
        return Arrays.asList(new Object[][]{{true, null}, {true, "1"},
                {false, "1,2,#,3"}, {false, "1,#,2,#,3"}, {false, "1,2,#,#,3"}, {false, "1,2,2,3,#,#,3,4,#,#,4"}
        });
    }

    @Test
    public void test() {
        BalancedBinaryTree tree = new BalancedBinaryTree();
        TreeNode root = TreeNodeSerializer.toTree(string);
        assertEquals(expect, tree.isBalanced(root));
    }
}
