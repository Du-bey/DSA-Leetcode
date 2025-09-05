class Solution {
    public int calculateMinimumHP(int[][] d) {
        int n = d.length;
        int m = d[0].length;
        int[][] dp = new int[n][m];

        dp[n-1][m-1] = Math.max(1, 1 - d[n-1][m-1]);

        for(int i = n-2;i>=0;i--){
            dp[i][m-1] = Math.max(1, dp[i+1][m-1] - d[i][m-1]);
        }

        for(int j = m-2;j>=0;j--){
            dp[n-1][j] = Math.max(1, dp[n-1][j+1] - d[n-1][j]);
        }

        for(int i = n-2;i>=0;i--){
            for(int j = m-2;j>=0;j--){
                int down = dp[i+1][j];
                int r = dp[i][j+1];

                int ans = Math.min(down, r) - d[i][j];
                dp[i][j] = Math.max(1, ans);
            }
        }
        return dp[0][0];
    }
}