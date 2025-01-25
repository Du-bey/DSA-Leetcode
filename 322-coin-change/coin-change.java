class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+2][amount+1];
        for(int i =0;i<=amount;i++){
            dp[0][i] = 100000000;
        }
        dp[0][0] = 0;
        for(int i =1;i<=n;i++){
            for(int t = 1;t<=amount;t++){
                int take = 100000000;
                if(coins[i-1] <= t) take = 1 + dp[i][t - coins[i-1]];
                int notTake = dp[i-1][t];
                
                dp[i][t] = Math.min(take, notTake);
            }
        }
        int ans = dp[n][amount];
        return ans == 100000000 ? -1 : ans;
    }
}