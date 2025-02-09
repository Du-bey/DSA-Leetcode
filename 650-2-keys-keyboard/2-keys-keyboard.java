class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        int[][] dp = new int[n+1][n+1];
        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
        return 1 + f(1, 1, n, dp);
    }

    public int f(int c, int p, int n, int[][] dp){
        if(c == n) return 0;
        if(c > n) return 100000;

        if(dp[c][p] != -1) return dp[c][p];

        int v1 = 1 + f(c+p, p, n, dp);
        int v2 = 2 + f(c+c, c, n, dp);
        return dp[c][p] = Math.min(v1, v2);
    }
}