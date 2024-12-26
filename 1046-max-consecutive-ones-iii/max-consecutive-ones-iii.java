class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int ans = 0;
        int zero = 0;
        for(int r = 0;r < n; r++){
            if(nums[r] == 0) zero++;
            while(zero > k){
                if(nums[l] == 0) zero--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}