class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int p =0;
        for(int i =1;i<n;i++){
            int cost = prices[i] - min;
            p = Math.max(p, cost);
            min = Math.min(prices[i], min);
        }
        return p;
    }
}