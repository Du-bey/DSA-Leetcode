class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i =0;i<m;i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i =1;i<n;i++){
            for(int j=0;j<m;j++){
                int down = dp[i-1][j];
                int left = dp[i-1][Math.max(0, j -1)];
                int right = dp[i-1][Math.min(m-1, j + 1)];

                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(left, right));
            }
        }
        for(int i =0;i<m;i++){
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;
    }
}