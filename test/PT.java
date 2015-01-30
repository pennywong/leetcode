import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Penny on 2014/12/10
 */
public class PT {
    @Test
    public void test() {
        WordLadderII wordLadderII = new WordLadderII();
        Set<String> set = new HashSet<String>();
        set.add("ted");
        set.add("tex");
        set.add("red");
        set.add("tax");
        set.add("tad");
        set.add("den");
        set.add("rex");
        set.add("pee");
        System.out.println(wordLadderII.findLadders("red", "tax", set));
    }
}
