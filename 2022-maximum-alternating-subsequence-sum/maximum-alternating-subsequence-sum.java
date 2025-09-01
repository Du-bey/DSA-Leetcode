class Solution {
    long[][] dp;
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        dp = new long[n][2];

        for(long[] r : dp){
            r[0] = -1;
            r[1] = -1;
        }
        return solve(0, nums, 1);
    }

    public long solve(int i, int[] nums, int even){
        int n = nums.length;
        if(i == n) return 0;

        if(dp[i][even] != -1) return dp[i][even];
        
        long num = (even == 1) ? nums[i] : -nums[i];
        long take = num + solve(i+1, nums, 1 - even);
        long notTake = solve(i+1, nums, even);

        dp[i][even] = Math.max(take, notTake);
        return dp[i][even];
    }
}