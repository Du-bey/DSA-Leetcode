class Solution {
    public int maxScore(int[] arr, int k) {
        int n = arr.length;
        int lsum = 0, rsum = 0, ans = 0;
        for(int i =0;i< k;i++){
            lsum += arr[i];
        }
        ans = lsum;
        int r = n - 1;
        for(int i = k-1;i>=0;i--){
            lsum -= arr[i];
            rsum += arr[r];
            r--;
            ans = Math.max(ans, lsum + rsum);
        }
        return ans;
    }
}