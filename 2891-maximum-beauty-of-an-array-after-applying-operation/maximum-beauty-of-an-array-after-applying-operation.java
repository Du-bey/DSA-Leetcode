class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int ans = 0;
        for(int r = 0;r < nums.length;r++){
            while(nums[r] - nums[l] > 2 *k) l++;
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}