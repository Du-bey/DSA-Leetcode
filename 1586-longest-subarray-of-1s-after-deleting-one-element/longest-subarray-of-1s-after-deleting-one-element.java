class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int last = -1;
        int ans = 0;
        int j = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == 0){
                j = last + 1;
                last = i;
            }
            ans = Math.max(ans, i-j);
        }
        return ans;
    }
}