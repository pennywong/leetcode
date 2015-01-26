/**
 * https://oj.leetcode.com/problems/jump-game-ii/
 * <p/>
 * Created by Penny on 2015/01/21
 */
public class JumpGameII {
    /**
     * 参考：http://blog.csdn.net/pickless/article/details/9776661
     * http://www.cnblogs.com/changchengxiao/p/3594701.html
     */
    public int jump(int[] A) {
        int[] dp = new int[A.length];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = max - i + 1; j <= A[i] && (i + j) < A.length; j++)
                dp[i + j] = dp[i] + 1;

            max = Math.max(max, A[i] + i);
        }

        return dp[A.length - 1];
    }
}
