class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return f(0, 1, prices, dp);
    }

    public int f(int i, int buy, int[] prices, int[][] dp){
        int n = prices.length;
        if(i > n-1) return 0;
        
        if(dp[i][buy] != -1) return dp[i][buy];
        if(buy == 1){
            dp[i][buy] = Math.max(-prices[i] + f(i+1, 0, prices, dp), f(i+1, 1, prices, dp));
        }
        else{
            dp[i][buy] = Math.max(prices[i] + f(i+1, 1, prices, dp), f(i+1, 0, prices, dp));
        }
        return dp[i][buy];
    }
}