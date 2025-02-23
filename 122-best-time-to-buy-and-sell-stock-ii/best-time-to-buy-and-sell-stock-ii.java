class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return f(0, 1, prices, dp);
    }

    public int f(int i, int buy, int[] p, int[][] dp){
        if(i == p.length) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        int ans = 0;
        if(buy == 1){
            ans = Math.max(-p[i] + f(i+1, 0, p, dp), f(i+1, 1, p, dp));
        }
        else{
            ans = Math.max(p[i] + f(i+1, 1, p, dp), f(i+1, 0, p, dp));
        }
        return dp[i][buy] = ans;
    }
}