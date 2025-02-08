class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = -1000000;
        int sum = 0;
        for(int i =0;i<n;i++){
            sum = Math.max(sum, 0);
            sum += nums[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}