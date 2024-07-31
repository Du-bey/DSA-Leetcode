class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        for(int i =1;i<n;i++){
            int p = prices[i] - prices[i-1];
            ans = Math.max(ans, ans + p);
        }
        return ans;
    }
}