/**
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * <p/>
 * Created by Penny on 2015/01/07
 */
public class BestTimeToBuyAndSellStock {
    /**
     * 道理和https://oj.leetcode.com/problems/maximum-subarray/这一题是一样的
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (sum < 0)
                sum = 0;
            sum += prices[i] - prices[i - 1];

            if (max < sum)
                max = sum;
        }

        return max;
    }
}
