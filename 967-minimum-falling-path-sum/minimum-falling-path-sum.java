class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        int [][] dp = new int[n][m];
        
        for(int i =0;i<m;i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i =1;i<n;i++){
            for(int j =0;j<m;j++){
                int lu = 10000000;
                int ru = 10000000;
                if(j-1 >= 0) lu = dp[i-1][j-1];
                int u = dp[i-1][j];
                if(j < m-1) ru = dp[i-1][j+1];
                dp[i][j] = matrix[i][j] + Math.min(lu, Math.min(u, ru));
            }
        }

        for(int i = 0;i<m;i++){
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;
    }

    public int f(int i, int j, int[][] matrix, int n, int m, int [][] dp){
        if( j<0 || j > m-1) return 10000000;
        if(i == 0) return matrix[0][j];
        if(dp[i][j] != -1) return dp[i][j];
        int lu = f(i-1, j-1, matrix, n, m, dp);
        int u = f(i-1, j, matrix, n, m, dp);
        int ru = f(i-1, j+1, matrix, n, m, dp);

        dp[i][j] = matrix[i][j] + Math.min(lu, Math.min(u, ru));
        return dp[i][j];
    }
}