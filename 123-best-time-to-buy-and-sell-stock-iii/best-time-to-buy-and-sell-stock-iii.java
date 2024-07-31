class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] next = new int[2][3];
        int[][] cur = new int[2][3];
        for(int ind = n-1;ind >=0; ind--){
            for(int buy = 0; buy < 2;buy++){
                for(int cap = 1; cap<3; cap++){
                    int p = 0;
                    if(buy == 1){
                        p = Math.max(-prices[ind] + next[0][cap], next[1][cap]);
                    }
                    else{
                        p = Math.max(prices[ind] + next[1][cap-1], next[0][cap]);
                    }
                    cur[buy][cap] = p;
                }
            }
            next = cur;
        }
        return next[1][2];
    }
}