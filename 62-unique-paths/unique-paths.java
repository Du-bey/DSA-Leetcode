class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return f(m-1, n-1, m, n, dp);
    }

    public int f(int i, int j, int m, int n, int[][] dp){
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = f(i-1, j, m, n, dp) + f(i, j-1, m, n, dp);
    }
}