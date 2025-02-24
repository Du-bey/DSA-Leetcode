class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        if(sum % 2 == 1) return false;
        sum /= 2;
        int[][] dp = new int[n][sum+1];
        for(int[] r : dp) Arrays.fill(r, -1);
        return f(n-1, sum, dp, nums);
    }

    public boolean f(int i, int t, int[][] dp, int[] nums){
        if(t == 0) return true;
        if(i < 0 || t < 0) return false;

        if(dp[i][t] != -1) return dp[i][t] == 1 ? true : false;

        boolean take = f(i-1, t - nums[i], dp, nums);
        boolean notTake = f(i-1, t , dp, nums);
        boolean ans = take || notTake;
        dp[i][t] = ans ? 1 : 0;
        return ans;
    }
}