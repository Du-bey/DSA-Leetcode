class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int ans = 0;
        for(int i =1;i<n;i++){
            int p = prices[i] - min;
            ans = Math.max(ans, p);
            min = Math.min(min, prices[i]);
        }
        return ans;
    }
}