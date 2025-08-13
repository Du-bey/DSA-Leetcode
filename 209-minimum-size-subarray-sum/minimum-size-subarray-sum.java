class Solution {
    public int minSubArrayLen(int t, int[] nums) {
        int n = nums.length;
        int ans = n+1;
        int l = 0;
        int sum = 0;
        for(int r = 0;r < n;r++){
            sum += nums[r];
            while(sum >= t){
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return ans == n+1 ? 0 : ans;
    }
}