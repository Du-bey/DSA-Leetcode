class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int two = Math.max(nums[0], nums[1]);
        if(n == 2) return two;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = two;

        for(int i =2;i<n;i++){
            int take = nums[i] + dp[i-2];
            int notTake = dp[i-1];
            dp[i] = Math.max(take, notTake);
        }
        
        return dp[n-1];
    }
}