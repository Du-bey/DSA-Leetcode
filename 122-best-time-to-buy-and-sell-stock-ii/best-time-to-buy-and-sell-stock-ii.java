class Solution {
    public int maxProfit(int[] pr) {
        int n = pr.length;
        int[] next = new int[2];
        next[0] = 0;
        next[1] = 0;
        for(int ind = n-1; ind>= 0; ind--){
            int[] cur = new int[2];
            for(int buy = 0;buy<2;buy++){
                int p =0;
                if(buy == 1){
                    p = Math.max(-pr[ind] + next[0], next[1]);
                }
                else{
                    p = Math.max(pr[ind] + next[1], next[0]);
                }
                cur[buy] = p;
            }
            next = cur;
        }
        return next[1];
    }
}