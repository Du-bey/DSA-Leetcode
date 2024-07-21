class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int ans = -1;
        for(int num : prices){
            int c = num - min;
            ans = Math.max(ans, c);
            min = Math.min(min, num);
        }
        return ans;
    }
}