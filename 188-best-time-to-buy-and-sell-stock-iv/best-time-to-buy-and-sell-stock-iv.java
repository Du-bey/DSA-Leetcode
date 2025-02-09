class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int[][] r : dp){
            for(int[] c : r){
                Arrays.fill(c, -1);
            }
        }
        return f(0, 1, k, prices, dp);
    }

    public int f(int i, int buy, int cap, int[] prices, int[][][] dp){
        int n = prices.length;
        if(i > n-1 || cap == 0) return 0;
        
        if(dp[i][buy][cap] != -1) return dp[i][buy][cap];
        if(buy == 1){
            dp[i][buy][cap] = Math.max(-prices[i] + f(i+1, 0, cap, prices, dp), f(i+1, 1, cap,  prices, dp));
        }
        else{
            dp[i][buy][cap] = Math.max(prices[i] + f(i+1, 1, cap - 1, prices, dp), f(i+1, 0, cap, prices, dp));
        }
        return dp[i][buy][cap];
    }
}