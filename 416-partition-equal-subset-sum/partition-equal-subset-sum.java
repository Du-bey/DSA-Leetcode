class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        if(sum % 2 == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        
        dp[0] = true;
        for(int i =1;i<=n;i++){
            for(int j =sum;j>=1;j--){
                boolean notTake = dp[j];
                boolean take = false;
                if(nums[i-1]<= j) take = dp[j - nums[i-1]];
                dp[j] = take || notTake;
            }
        }
        return dp[sum];
    }
}