class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i =0;i<=n;i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return f(0, 1, n, prices, dp);
    }

    public int f(int ind, int buy, int n, int[] pr, int[][] dp){
        if(ind == n) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        int ans = 0;
        if(buy == 1){
            ans = Math.max(-pr[ind] + f(ind + 1, 0, n, pr, dp), f(ind + 1, 1, n, pr, dp));
        }
        else{
            ans = Math.max(pr[ind] + f(ind + 1, 1, n, pr, dp), f(ind + 1, 0, n, pr, dp));
        }
        dp[ind][buy] = ans;
        return dp[ind][buy];
    }
}