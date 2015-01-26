import java.util.HashSet;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/first-missing-positive/
 * <p/>
 * Created by Penny on 2015/01/20
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        int i = 1;
        while (set.contains(i)) {
            i++;
        }

        return i;
    }
}
