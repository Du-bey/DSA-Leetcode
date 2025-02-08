class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return f(m-1, n-1, m, n, dp, grid);
    }

    public int f(int i, int j, int m, int n, int[][] dp, int[][] grid){
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];
        int up = f(i-1, j, m, n, dp, grid);
        int left = f(i, j-1, m, n, dp, grid);
        dp[i][j] = grid[i][j] + Math.min(up, left);
        return dp[i][j];
    }
}