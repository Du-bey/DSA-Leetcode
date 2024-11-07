class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return f(0, -1, nums, n, dp);
    }

    public int f(int i, int prev, int[] nums, int n, int[][] dp){
        if(i == n) return 0;
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        int take = 0;
        if(prev == -1 || nums[i] > nums[prev]) take = 1 + f(i+1, i, nums, n, dp);
        int notTake = f(i+1, prev, nums, n, dp);

        return dp[i][prev+1] = Math.max(take, notTake);
    }
}