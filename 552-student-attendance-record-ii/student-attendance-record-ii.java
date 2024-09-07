class Solution {
    final int mod = 1000000007;
    public int checkRecord(int n) {
        int[][][] dp = new int[n+1][2][3];
        for(int[][] r : dp){
            for(int[] r2 : r){
                Arrays.fill(r2, -1);
            }
        }
        return f(n, 0, 0, dp);
    }

    public int f(int i, int a, int l, int[][][] dp){
        if(i == 0) return 1;
        if(dp[i][a][l] == -1){
            int ab = f(i-1, a ,0, dp) % mod;
            if(a < 1) ab = (ab + f(i-1, a+1, 0, dp)) % mod;
            if(l < 2) ab = (ab + (f(i-1, a, l+1, dp)) % mod);
            
            dp[i][a][l] = (ab) % mod;
        }
        return dp[i][a][l] % mod;
    }
}