class Solution {
    int mod = 100000000;
    public int coinChange(int[] coins, int t) {
        int n = coins.length;
        int[][] dp = new int[n][t+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans = f(n-1, t, coins, dp);
        if(ans >= mod){
            return -1;
        }
        return ans;
    }

    public int f(int ind, int t, int[] coins, int[][] dp){
        if(ind < 0){
            return t == 0 ? 0 : mod;
        }
        if(dp[ind][t] != -1) return dp[ind][t];
        int notTake = f(ind-1, t, coins, dp);
        int take = mod;
        if(coins[ind] <= t){
            take = 1 + f(ind, t-coins[ind], coins, dp);
        }
        dp[ind][t] = Math.min(take, notTake);
        return dp[ind][t];
    }
}