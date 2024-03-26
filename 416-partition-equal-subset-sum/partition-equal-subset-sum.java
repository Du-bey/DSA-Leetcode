class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i =0;i<n;i++){
            sum+= nums[i];
        }
        if(sum % 2 == 1) return false;
        sum = sum/2;
        boolean[][] dp = new boolean[n][sum+1];
        for(int i =0;i<n;i++) dp[i][0] = true;
        if(nums[0] <= sum) dp[0][nums[0]] = true;
        for(int i= 1;i<n;i++){
            for(int t =1;t < sum+1;t++){
                boolean notTake = dp[i-1][t];
                boolean take = false;
                if(nums[i] <= t) take = dp[i-1][t-nums[i]];
                dp[i][t] = take || notTake;
            }
        }
        return dp[n-1][sum];
    }
}