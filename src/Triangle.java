import java.util.List;

/**
 * https://oj.leetcode.com/problems/triangle/
 * <p/>
 * Created by Penny on 25/1/15.
 */
public class Triangle {
    /**
     * 参考：http://www.cnblogs.com/bigbigtree/p/3890132.html
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = triangle.get(n - 1).get(i);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}
