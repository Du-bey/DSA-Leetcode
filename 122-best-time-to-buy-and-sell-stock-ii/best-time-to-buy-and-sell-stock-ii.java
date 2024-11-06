class Solution {
    public int maxProfit(int[] p) {
        int n = p.length;
        int[] prev = new int[2];
        for(int i =n-1;i>=0;i--){
            int[] cur = new int[2];
            for(int buy = 0;buy<2;buy++){
                if(buy == 1){
                    cur[buy] = Math.max(-p[i] + prev[0], prev[1]);
                }
                else{
                    cur[buy] = Math.max(p[i] + prev[1], prev[0]);
                }
                prev = cur;
            }
        }
        return prev[1];
    }
}