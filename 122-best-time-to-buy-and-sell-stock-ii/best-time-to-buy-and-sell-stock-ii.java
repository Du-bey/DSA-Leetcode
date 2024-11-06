class Solution {
    public int maxProfit(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][2];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return f(0, 1, n, p, dp);
    }

    public int f(int i, int buy, int n, int[] p, int[][] dp){
        if(i == n) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        int ans = 0;
        if(buy == 1){
            ans = Math.max(-p[i] + f(i+1, 0, n, p, dp), f(i+1, 1, n, p, dp));
        }
        else{
            ans = Math.max(p[i] + f(i+1, 1, n, p, dp), f(i+1, 0, n, p, dp));
        }
        return dp[i][buy] = ans;
    }
}