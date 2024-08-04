class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        for(int i =0;i<m;i++){
            dp[i][0] = 1;
        }

        for(int i =0;i<n;i++){
            dp[0][i] = 1;
        }

        for(int i =1;i<m;i++){
            for(int j =1;j<n;j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }

    public int f(int m, int n, int [][] dp){
        if(m < 0 || n < 0) return 0;
        if(m == 0 || n == 0) return 1;

        if(dp[m][n] != -1) return dp[m][n];
        dp[m][n] = f(m, n-1, dp) + f(m-1, n, dp);
        return dp[m][n];
    }
}