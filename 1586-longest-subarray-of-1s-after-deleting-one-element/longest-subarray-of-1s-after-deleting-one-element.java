class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int last = 0;
        int ans = 0;
        int zero = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == 0) zero++;
            while(zero > 1){
                if(nums[last] == 0) zero--;
                last++;
            }
            ans = Math.max(ans, i-last);
        }
        return ans;
    }
}