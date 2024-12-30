class Solution {
    int MOD = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high +1];
        Arrays.fill(dp, -1);
        return f(low, high, zero, one, 0, dp) % MOD;
    }

    public int f(int low, int high, int zero, int one, int len, int[] dp){
        int cnt = 0;
        if(len > high) return 0;
        if(dp[len] != -1) return dp[len];
        if(len >= low) cnt = 1;
        cnt %= MOD;
        cnt += f(low, high, zero, one, len + one, dp);
        cnt %= MOD;
        cnt += f(low, high, zero, one, len + zero, dp);
        cnt %= MOD;
        
        return dp[len] = cnt;
    }
}