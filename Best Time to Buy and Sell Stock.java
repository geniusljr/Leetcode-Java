public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null || prices.length == 0)
            return 0;
        int minP = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = prices[i] - minP > maxProfit ? prices[i] - minP : maxProfit;
            minP = prices[i] < minP ? prices[i] : minP;
        }
        return maxProfit;
    }
}