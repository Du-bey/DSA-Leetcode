class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int cnt = 1;
        
        for(int i =1;i<n;i++){
            cnt = (nums[i] > nums[i-1]) ? cnt + 1 : 1;
            ans = Math.max(ans, cnt);
        }
        cnt = 1;
        for(int i =1;i<n;i++){
            cnt = (nums[i] < nums[i-1]) ? cnt + 1 : 1;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}