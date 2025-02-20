class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[][] dp = new int[nums.length][target+1];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return solve(0, nums, target, dp);
    }

    public int solve(int i, int[] nums, int t, int[][] dp){
        if(t == 0){
            return 1;
        }
        if(i == nums.length || t < 0) return 0;

        if(dp[i][t] != -1) return dp[i][t];
        int take = solve(0, nums, t - nums[i], dp);
        int notTake = solve(i+1, nums, t, dp);
        
        return dp[i][t] = take + notTake;
    }
}