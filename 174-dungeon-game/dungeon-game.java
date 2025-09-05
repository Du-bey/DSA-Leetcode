class Solution {
    int n;
    int m;
    int[][] dp;
    public int calculateMinimumHP(int[][] d) {
        n = d.length;
        m = d[0].length;
        dp = new int[n][m];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return f(0, 0, d);
    }

    public int f(int i, int j, int[][] d){
        if(i == n || j == m) return 1000000;
        if(i == n - 1 && j == m - 1){
            return Math.max(1, 1 - d[i][j]);
        }
        
        if(dp[i][j] != -1) return dp[i][j];

        int down = f(i+1, j, d);
        int r = f(i, j+1, d);

        int ans = Math.min(down, r) - d[i][j];
        return dp[i][j] = Math.max(1, ans);
    }
}