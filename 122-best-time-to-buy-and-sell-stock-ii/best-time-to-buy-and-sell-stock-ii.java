class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0;i<n;i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return f(0, 1, prices, dp);
    }

    public int f(int i, int buy, int[] prices, int[][] dp){
        int n = prices.length;
        if(i == n) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        int ans = 0;
        if(buy == 1){
            ans = Math.max(-prices[i] + f(i+1, 0, prices, dp), f(i+1, 1, prices, dp));
        }
        else{
            ans = Math.max(prices[i] + f(i+1, 1, prices, dp), f(i+1, 0, prices, dp));
        }
        dp[i][buy] = ans;
        return ans;
    }
}