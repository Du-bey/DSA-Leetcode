class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
        return f(m-1, n-1, dp, grid);
    }

    public int f(int i, int j, int[][] dp, int[][] grid){
        if(i >=0 && j>= 0 && grid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        if(i < 0 && j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int up = 0;
        int left = 0;
        if(i > 0) up = f(i-1, j, dp, grid);
        if(j > 0) left = f(i, j-1, dp, grid);
        int ans = up + left;
        dp[i][j] = ans;
        return dp[i][j];

    }
}