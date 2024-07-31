class Solution {
    public int maxProfit(int[] pr) {
        int n = pr.length;
        int nextBuy = 0;
        int nextNotBuy = 0;
        int curBuy = 0;
        int curNotBuy = 0;
        for(int ind = n-1; ind>= 0; ind--){
            curBuy = Math.max(-pr[ind] + nextNotBuy, nextBuy);
            curNotBuy = Math.max(pr[ind] + nextBuy, nextNotBuy);
            nextBuy = curBuy;
            nextNotBuy = curNotBuy;
        }
        return nextBuy;
    }
}