class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] r : dp){
            for(int[] c : r){
                Arrays.fill(c, -1);
            }
        }
        return f(0, 1, 2, prices, dp);
    }

    public int f(int i, int buy, int k, int[] prices, int[][][] dp){
        int n = prices.length;
        if(i == n || k == 0) return 0;

        if(dp[i][buy][k] != -1) return dp[i][buy][k];

        int ans = 0;
        if(buy == 1){
            ans = Math.max(-prices[i] + f(i+1, 0, k, prices, dp), f(i+1, 1, k, prices, dp));
        }
        else{
            ans = Math.max(prices[i] + f(i+1, 1, k-1, prices, dp), f(i+1, 0, k, prices, dp));
        }
        dp[i][buy][k] = ans;
        return ans;
    }
}