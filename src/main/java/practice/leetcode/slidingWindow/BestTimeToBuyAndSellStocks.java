package practice.leetcode.slidingWindow;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        test(new int[]{7,1,5,3,6,4}, 5);
        test(new int[]{7,6,4,3,1}, 0);
        test(new int[]{2,1,4}, 3);
        test(new int[]{2,0,4}, 4);
        test(new int[]{2,1,1,4}, 3);
        test(new int[]{3,2,6,0,5,3}, 5);
    }

    private static void test(int[] prices, int expected) {
        System.out.printf("Result: %d, Expected: %d.\n", maxProfit(prices), expected);
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buyIdx = 0;
        int sellIdx = 1;

        while (buyIdx < sellIdx && sellIdx < prices.length) {
            if (prices[buyIdx] > prices[sellIdx]) {
                buyIdx = sellIdx;
                sellIdx++;
            }
            else {
                profit = Math.max(profit, prices[sellIdx] - prices[buyIdx]);
                sellIdx++;
            }
        }
        return profit;
    }
}
