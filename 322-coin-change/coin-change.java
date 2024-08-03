class Solution {
    int mod = 100000000;
    public int coinChange(int[] coins, int t) {
        int n = coins.length;
        int[][] dp = new int[n][t+1];

        for(int i =0;i<=t;i++){
            dp[0][i] = (i%coins[0]) == 0 ? i/coins[0] : mod;
        }

        for(int i =1;i<n;i++){
            for(int j = 0;j<=t;j++){
                int notTake = dp[i-1][j];
                int take = mod;
                if(coins[i] <= j){
                    take = 1 + dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(take, notTake);
            }
        }
        return dp[n-1][t] >= mod ? -1 : dp[n-1][t];
    }
}