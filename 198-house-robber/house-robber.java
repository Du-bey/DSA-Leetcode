class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(n-1, nums, dp);
    }

    public int f(int i, int[] nums, int[] dp){
        if(dp[i] != -1) return dp[i];
        if(i == 0) return nums[0];
        if(i == 1) return Math.max(nums[0], nums[1]);

        dp[i] = Math.max(f(i-1, nums, dp), nums[i] + f(i-2, nums, dp));
        return dp[i];
    }
}