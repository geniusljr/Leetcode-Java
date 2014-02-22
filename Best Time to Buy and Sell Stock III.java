public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null || prices.length <= 1)
            return 0;
        int[] maxProfit1 = new int[prices.length];
        int[] maxProfit2 = new int[prices.length];
        
        int minP = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = prices[i] - minP > maxProfit ? prices[i] - minP : maxProfit;
            minP = prices[i] < minP ? prices[i] : minP;
            maxProfit1[i] = maxProfit;
        }
        int maxP = prices[prices.length-1];
        maxProfit = 0;
        for (int i = prices.length-1; i >= 0; i--) {
            maxProfit = maxP - prices[i] > maxProfit ? maxP - prices[i] : maxProfit;
            maxP = prices[i] > maxP ? prices[i] : maxP;
            maxProfit2[i] = maxProfit;
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++)
            max = maxProfit1[i]+maxProfit2[i] > max ? maxProfit1[i]+maxProfit2[i] : max;
        return max;
    }
}