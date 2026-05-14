class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int currProfit = 0; 

        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } 

            else {
                int profit = prices[i] - minPrice; 
                if (profit > currProfit) {
                    currProfit = profit; 
                }
            }
        }

        return currProfit;
        
    }
}
