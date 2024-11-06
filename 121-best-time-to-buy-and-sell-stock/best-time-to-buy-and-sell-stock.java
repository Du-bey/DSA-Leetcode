class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        for(int x : prices){
            profit = Math.max(profit, x - min);
            min = Math.min(min, x);
        }
        return profit;
    }
}