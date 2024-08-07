class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return f(0, -1, nums, dp);
    }

    public int f(int i, int prev, int[] nums, int[][] dp){
        if(i == nums.length) return 0;
        
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        int notTake = 0 + f(i+1, prev, nums, dp);
        int take = -100000000;
        if(prev == -1 || nums[i] > nums[prev]) take = 1 + f(i+1, i, nums, dp);
        dp[i][prev+1] = Math.max(take, notTake);
        return Math.max(take, notTake);
    }
}