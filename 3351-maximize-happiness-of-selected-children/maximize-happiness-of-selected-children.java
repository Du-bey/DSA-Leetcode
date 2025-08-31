class Solution {
    public long maximumHappinessSum(int[] h, int k) {
        Arrays.sort(h);
        int n = h.length;
        long ans = 0;
        int pick = 0;
        for(int i = n-1;i>=0;i--){
            ans += Math.max(0, h[i] - pick);
            pick++;
            if(pick == k) break;
        }
        return ans;
    }
}