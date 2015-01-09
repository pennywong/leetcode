/**
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * <p/>
 * Created by Penny on 2015/01/09
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0)
                profit += diff;
        }

        return profit;
    }
}
