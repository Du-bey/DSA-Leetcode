class Solution {

    int[][] dp;
    public int uniquePathsWithObstacles(int[][] g) {
        int m = g.length;
        int n = g[0].length;
        dp = new int[m][n];
        for(int[] r : dp) Arrays.fill(r, -1);
        return f(m-1, n-1, g);
    }

    public int f(int i, int j, int[][] g){
        if(i < 0 || j < 0 || g[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;

        if(dp[i][j] != -1) return dp[i][j];
        int up = f(i-1, j, g);
        int left = f(i, j-1, g);
        dp[i][j] = up + left;
        return dp[i][j];
    }
}