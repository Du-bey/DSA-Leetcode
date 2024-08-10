class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int i =0;i<n;i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i =1;i<n;i++){
            for(int j =0;j<n;j++){
                int ul = 1000000000;
                int ur = 1000000000;
                int up = dp[i-1][j];
                if(j>0) ul = dp[i-1][j-1];
                if(j<n-1) ur = dp[i-1][j+1];
                int c = matrix[i][j] + Math.min(up, Math.min(ul,ur));
                dp[i][j] = c;
            }
        }    
        for(int i = 0;i<n;i++){
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;
    }
}