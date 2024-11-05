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

    public int f(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return 100000000;
        if(dp[i][j] != -1) return dp[i][j];

        dp[i][j] = grid[i][j] + Math.min(f(i-1, j, grid, dp), f(i, j-1, grid, dp));
        return dp[i][j];
    }
}