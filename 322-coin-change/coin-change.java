class Solution {
    public int coinChange(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target+1];
        for(int t =0;t <= target;t++){
            if(t%coins[0] == 0) dp[0][t] = t/coins[0];
            else dp[0][t] = 10000000;
        }
        for(int i =1;i<n;i++){
            for(int j =0;j<= target;j++){
                int notTake = dp[i-1][j];
                int take = 10000000;
                if(coins[i] <= j){
                    take = 1 + dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(take, notTake);
            }
        }
        return dp[n-1][target] >= 10000000 ? -1 : dp[n-1][target];
    }
}