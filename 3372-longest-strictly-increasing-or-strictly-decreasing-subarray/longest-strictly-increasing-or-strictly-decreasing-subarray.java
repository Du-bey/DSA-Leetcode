class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int ans = 1, inc = 1, dec = 1;
        
        for(int i =1;i<n;i++){
            inc = (nums[i] > nums[i-1]) ? inc + 1 : 1;
            dec = (nums[i] < nums[i-1]) ? dec + 1 : 1;
            ans = Math.max(ans, Math.max(inc, dec));
        }
        return ans;
    }
}