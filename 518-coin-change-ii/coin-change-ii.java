class Solution {
    public int change(int target, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][target+1];
        for(int t =0;t <= target;t++){
            dp[0][t] = (t%coins[0] == 0) ? 1 : 0;
            
        }
        for(int i =1;i<n;i++){
            for(int j =0;j<= target;j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(coins[i] <= j){
                    take = dp[i][j-coins[i]];
                }
                dp[i][j] = take + notTake;
            }
        }
        return dp[n-1][target];
    }
}