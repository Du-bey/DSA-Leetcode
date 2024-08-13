class Solution {
    public int maxScore(int[] c, int k) {
        int n = c.length;
        int sum = 0;
        for(int i =0;i<n;i++){
            sum += c[i];
        }
        if(k >= n) return sum;
        int ans = 0;
        int l = 0;
        int r = n - k;
        int lSum = 0;
        for(int i =r;i<n;i++){
            lSum += c[i];
        }
        ans = lSum;
        while(r < n){
            lSum = lSum + c[l] - c[r];
            ans = Math.max(ans, lSum);
            l++;
            r++;
        }
        return ans; 
    }
}