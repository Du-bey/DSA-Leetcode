class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] r : dp) Arrays.fill(r, -1);
        return f(m-1, n-1);
    }

    public int f(int i, int j){
        if(i < 0 || j < 0) return 0;
        if(i == 0 || j == 0) return 1;

        if(dp[i][j] != -1) return dp[i][j];
        int up = f(i-1, j);
        int left = f(i, j-1);
        dp[i][j] = up + left;
        return dp[i][j];
    }
}