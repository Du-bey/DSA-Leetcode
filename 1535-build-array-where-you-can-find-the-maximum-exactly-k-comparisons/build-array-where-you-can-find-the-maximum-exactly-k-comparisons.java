class Solution {
    int mod = 1000000007;
    long[][][] dp;
    public int numOfArrays(int n, int m, int k) {
        dp = new long[n+1][k+1][m+1];
        for(long[][] r : dp){
            for(long[] c : r){
                Arrays.fill(c, -1);
            }
        }
        return (int)f(0, n, m, k, 0);
    }

    public long f(int i, int n, int m, int k, int l){
        if(k < 0) return 0;
        if(i == n){
            return (k == 0) ? 1 : 0;
        }

        if(dp[i][k][l] != -1) return dp[i][k][l];
        long ways = 0;
        for(int j =1;j<=m;j++){
            if(j > l){
                ways += f(i+1, n, m, k-1, j);
            }
            else{
                ways += f(i+1, n, m, k, l);
            }
        }
        dp[i][k][l] = ways % mod;
        return dp[i][k][l];
    }
}

