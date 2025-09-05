class Solution {
    int mod = 1000000007;
    int n;
    int m;
    long[][][] dp;
    public int maxProductPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new long[n][m][2];

        for(long[][] r : dp){
            for(long[] c : r){
                c[0] = Long.MAX_VALUE;
                c[1] = Long.MIN_VALUE;
            }
        }

        long[] ans = f(0, 0, grid);
        long max = ans[1];

        if(max < 0) return -1;
        max %= mod;
        return (int) max;
    }

    public long[] f(int i, int j, int[][] grid){
        int val = grid[i][j];
        if(i == n-1 && j == m-1) return new long[]{val, val};

        if(dp[i][j][0] != Long.MAX_VALUE && dp[i][j][1] != Long.MIN_VALUE) return dp[i][j];

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        if(i + 1 < n){
            long[] down = f(i+1, j, grid);
            long dmax = down[1];
            long dmin = down[0];

            max = Math.max(max, Math.max(val * dmax, val * dmin));
            min = Math.min(min, Math.min(val * dmax, val * dmin));
        }

        if(j + 1 < m){
            long[] r = f(i, j+1, grid);
            long rmax = r[1];
            long rmin = r[0];

            max = Math.max(max, Math.max(val * rmax, val * rmin));
            min = Math.min(min, Math.min(val * rmax, val * rmin));
        }

        long[] ans = new long[]{min, max};
        dp[i][j] = ans;
        return ans;
    }
}