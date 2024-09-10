class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(f(n-1, cost, dp), f(n-2, cost, dp));
    }
    
    public int f(int i, int[] cost, int[] dp){
        if(i < 0) return 0;
        if(i == 0 || i == 1) return cost[i];

        if(dp[i] != -1) return dp[i];

        dp[i] = cost[i] + Math.min(f(i-1, cost, dp), f(i-2, cost, dp));
        return dp[i];
    }
}