class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int cnt = 1;
        int cnt2 = 1;
        
        for(int i =1;i<n;i++){
            cnt = (nums[i] > nums[i-1]) ? cnt + 1 : 1;
            cnt2 = (nums[i] < nums[i-1]) ? cnt2 + 1 : 1;
            ans = Math.max(ans, Math.max(cnt, cnt2));
        }
        return ans;
    }
}