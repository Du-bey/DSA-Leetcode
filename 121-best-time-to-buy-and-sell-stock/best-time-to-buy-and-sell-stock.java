class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        int min = prices[0];
        for(int x : prices){
            min = Math.min(min, x);
            ans = Math.max(ans, x - min);
        }
        return ans;
    }
}