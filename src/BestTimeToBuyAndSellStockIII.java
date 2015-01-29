/**
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * <p/>
 * Created by Penny on 2015/01/27
 */
public class BestTimeToBuyAndSellStockIII {
    /**
     * 参考：http://www.acmerblog.com/leetcode-best-time-to-buy-and-sell-stock-6032.html
     * http://blog.unieagle.net/2012/12/05/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Abest-time-to-buy-and-sell-stock-iii%EF%BC%8C%E4%B8%80%E7%BB%B4%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92/
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int n = prices.length;
        int[] opt = new int[n];
        opt[0] = 0;
        int low = prices[0];
        int currentAns = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] < low)
                low = prices[i];
            else if (currentAns < prices[i] - low)
                currentAns = prices[i] - low;
            opt[i] = currentAns;
        }

        int[] optReverse = new int[n];
        optReverse[n - 1] = 0;
        currentAns = 0;
        int high = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (prices[i] > high)
                high = prices[i];
            else if (currentAns < high - prices[i])
                currentAns = high - prices[i];
            optReverse[i] = currentAns;
        }

        int result = 0;
        for (int i = 0; i < n; i++)
            result = Math.max(result, opt[i] + optReverse[i]);

        return result;
    }
}
