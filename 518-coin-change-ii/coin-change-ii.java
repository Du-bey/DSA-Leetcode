class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return f(n-1, n, coins, amount, dp);
    }

    public int f(int i, int n, int[] coins, int t, int[][] dp){
        if(t == 0) return 1;
        if(t < 0 || i < 0) return 0;

        if(dp[i][t] != -1) return dp[i][t];
        return dp[i][t] = f(i-1, n, coins, t, dp) + f(i, n, coins, t-coins[i], dp);
    }
}