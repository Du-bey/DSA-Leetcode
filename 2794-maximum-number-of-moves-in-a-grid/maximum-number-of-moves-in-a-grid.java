class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        int[][] dp = new int[n][m];
        for(int[] r: dp){
            Arrays.fill(r, -1);
        }
        for(int i =0;i<n;i++){
            ans = Math.max(ans,f(i, 0, grid, n, m, dp));
        }
        return ans;
    }

    public int f(int i, int j, int[][] grid, int n, int m, int[][] dp){
        if(j == m-1) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int val = grid[i][j];

        int ru = 0;
        int r = 0;
        int rd = 0;

        if(i > 0 && j < m-1 && grid[i-1][j+1] > val) ru = 1 + f(i-1, j+1, grid, n, m, dp);
        if(j < m-1 && grid[i][j+1] > val) r = 1 + f(i, j+1, grid, n, m, dp);
        if(i < n-1 && j < m-1 && grid[i+1][j+1] > val) rd = 1 + f(i+1, j+1, grid, n, m, dp);

        dp[i][j] = Math.max(ru, Math.max(r, rd));
        return dp[i][j];
    }
}