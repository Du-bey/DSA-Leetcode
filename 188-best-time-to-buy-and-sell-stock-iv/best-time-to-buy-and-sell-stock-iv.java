class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for(int i =n-1;i>=0;i--){
            for(int buy = 0;buy <2;buy++){
                for(int cap =k;cap>0;cap--){
                    if(buy == 1){
                        dp[i][buy][cap] = Math.max(-prices[i] + dp[i+1][0][cap], dp[i+1][1][cap]);
                    }
                    else{
                        dp[i][buy][cap] = Math.max(prices[i] + dp[i+1][1][cap-1], dp[i+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}