class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return f(n, dp);
    }

    public int f(int i, int[] dp){
        if(i < 0) return 0;
        if(i == 0) return 1;
        if(dp[i] != -1) return dp[i];

        return dp[i] = f(i-1, dp) + f(i-2, dp);
    }
}