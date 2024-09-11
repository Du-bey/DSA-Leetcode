class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        if(sum % 2 == 1) return false;
        sum /= 2;
        return isSubsetSum(n, nums, sum);
    }

    public boolean isSubsetSum(int n, int arr[], int sum){
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i =0;i<=sum;i++){
            dp[0][i] = false;
        }
        for(int i =0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int i =1;i<=n;i++){
            for(int j =1;j<= sum;j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(arr[i-1]<= j) take = dp[i-1][j - arr[i-1]];
                dp[i][j] = take || notTake;
            }
        }
        return dp[n][sum];
    }
}