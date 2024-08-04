class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
        return f(n-1, m-1, grid, dp);
    }

    public int f(int n, int m, int[][] grid, int[][] dp){
        if(n < 0 || m < 0) return 0;
        if(n ==0 && m == 0) return grid[0][0];
        if(dp[n][m] != -1) return dp[n][m];

        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(m > 0) up =  f(n, m-1, grid, dp);
        if(n > 0) left =  f(n-1, m, grid, dp);
        dp[n][m] = grid[n][m] + Math.min(up, left);
        return dp[n][m];
    }
}