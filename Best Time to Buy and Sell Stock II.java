public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null || prices.length < 2)
            return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += prices[i] > prices[i-1] ? prices[i]-prices[i-1] : 0;
        }
        return profit;
    }
}