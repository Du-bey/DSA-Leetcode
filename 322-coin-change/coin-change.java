class Solution {
    int min = 100000000;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int ans = f(n-1, amount, coins, dp);
        return ans == min ? -1 : ans;
    }

    public int f(int i, int t, int[] coins, int[][] dp){
        if(t == 0) return 0;
        if(i < 0 || t < 0) return min;

        if(dp[i][t] != -1) return dp[i][t];
        int take = 1 + f(i, t - coins[i], coins, dp);
        int notTake = f(i-1, t, coins, dp);

        return dp[i][t] = Math.min(take, notTake);
    }
}