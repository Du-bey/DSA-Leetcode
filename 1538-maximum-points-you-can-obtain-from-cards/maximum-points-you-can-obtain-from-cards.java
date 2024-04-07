class Solution {
    public int maxScore(int[] card, int k) {
        int n = card.length;
        int lsum = 0;
        int rsum = 0;
        int ans = 0;
        for(int i =0;i<k;i++){
            lsum += card[i];
        }
        ans = lsum;
        int r = n-1;
        for(int i = k-1;i>=0;i--){
            lsum = lsum - card[i];
            rsum += card[r];
            ans = Math.max(ans, lsum + rsum);
            r--;
        }
        return ans;
    }
}