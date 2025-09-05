class Solution {
    int mod = 1000000007;
    int n;
    int m;
    long[][][] dp;
    public int maxProductPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new long[n+1][m+1][2];

        int last = grid[n-1][m-1];

        dp[n-1][m-1] = new long[]{last, last};
        for(int i =n-2; i>=0;i--){
            long max = Math.max(grid[i][m-1] * dp[i+1][m-1][0], grid[i][m-1] * dp[i+1][m-1][1]);
            long min = Math.min(grid[i][m-1] * dp[i+1][m-1][0], grid[i][m-1] * dp[i+1][m-1][1]);
            dp[i][m-1] = new long[]{min, max};
        }

        for(int i = m-2;i>=0;i--){
            long max = Math.max(grid[n-1][i] * dp[n-1][i+1][0], grid[n-1][i] * dp[n-1][i+1][1]);
            long min = Math.min(grid[n-1][i] * dp[n-1][i+1][0], grid[n-1][i] * dp[n-1][i+1][1]);
            dp[n-1][i] = new long[]{min, max};
        }

        
        for(int i = n-2;i>=0;i--){
            for(int j = m-2;j>=0;j--){
                int val = grid[i][j];
                long max = Long.MIN_VALUE;
                long min = Long.MAX_VALUE;

                long[] down = dp[i+1][j];
                long dmax = down[1];
                long dmin = down[0];

                max = Math.max(max, Math.max(val * dmax, val * dmin));
                min = Math.min(min, Math.min(val * dmax, val * dmin));

                long[] r = dp[i][j+1];
                long rmax = r[1];
                long rmin = r[0];

                max = Math.max(max, Math.max(val * rmax, val * rmin));
                min = Math.min(min, Math.min(val * rmax, val * rmin));

                dp[i][j] = new long[]{min, max};
            }
        }

        long max = dp[0][0][1];

        if(max < 0) return -1;
        max %= mod;
        return (int) max;
    }
}