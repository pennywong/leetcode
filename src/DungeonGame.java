/**
 * https://oj.leetcode.com/problems/dungeon-game/
 * <p/>
 * Created by Penny on 2015/01/28
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        if (m == 0)
            return 0;
        int n = dungeon[0].length;
        if (n == 0)
            return 0;

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 0 : -dungeon[m - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int count = dungeon[m - 1][i] - dp[m - 1][i + 1];
            dp[m - 1][i] = count >= 0 ? 0 : -count;
        }

        for (int i = m - 2; i >= 0; i--) {
            int count = dungeon[i][n - 1] - dp[i + 1][n - 1];
            dp[i][n - 1] = count >= 0 ? 0 : -count;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int right = dungeon[i][j] - dp[i][j + 1];
                right = right >= 0 ? 0 : -right;
                int down = dungeon[i][j] - dp[i + 1][j];
                down = down >= 0 ? 0 : -down;
                dp[i][j] = Math.min(right, down);
            }
        }

        return dp[0][0] + 1;
    }
}
