class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return f(m-1, n-1, grid, dp);
    }

    public int f(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = Math.min(f(i-1, j, grid, dp), f(i, j-1, grid, dp)) + grid[i][j];
    }
}