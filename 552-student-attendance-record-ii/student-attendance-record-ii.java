class Solution {
    final int mod = 1000000007;
    public int checkRecord(int n) {
        int[][][] dp = new int[n+1][2][3];
        for(int i =0;i<2;i++){
            for(int j =0;j<3;j++){
                dp[0][i][j] = 1;
            }
        }
        for(int i =1;i<=n;i++){
            for(int a=1;a>=0;a--){
                for(int l =2;l>=0;l--){
                    int ab = dp[i-1][a][0] % mod;
                    if(a < 1) ab = (ab + dp[i-1][a+1][0]) % mod;
                    if(l < 2) ab = (ab + (dp[i-1][a][l+1]) % mod);
                    
                    dp[i][a][l] = (ab) % mod;
                }
            }
        }
        return dp[n][0][0] % mod;
    }

}