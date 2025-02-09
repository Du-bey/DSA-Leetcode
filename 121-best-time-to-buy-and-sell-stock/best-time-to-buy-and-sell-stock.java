class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int cost = prices[0];
        for(int i =0;i<n;i++){
            profit = Math.max(profit, prices[i] - cost);
            cost = Math.min(cost, prices[i]);
        }
        return profit;
    }
}