/**
 * https://oj.leetcode.com/problems/jump-game/
 * <p/>
 * Created by Penny on 17/1/15.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if (A.length == 0)
            return true;
        int maxStep = A[0];
        for (int i = 1; i < A.length; i++) {
            if (maxStep <= 0)
                return false;

            maxStep--;
            maxStep = Math.max(maxStep, A[i]);
        }
        return true;
    }
}
