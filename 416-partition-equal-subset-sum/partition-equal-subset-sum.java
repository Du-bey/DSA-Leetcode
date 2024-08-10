class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int no : nums){
            sum += no;
        }
        if(sum % 2 == 1) return false;
        return isSubsetSum(n, nums, sum/2);
    }

    static Boolean isSubsetSum(int n, int arr[], int s){
        // code here
        boolean[][] dp = new boolean[n][s+1];
        for(int i = 0;i<n;i++){
            dp[i][0] = true;
        }
        
        if(arr[0] <= s) dp[0][arr[0]] = true;
        for(int i =1;i<n;i++){
            for(int sum = 1;sum<=s;sum++){
                boolean take = false;
                boolean notTake = dp[i-1][sum];
                if(sum >= arr[i]) take = dp[i-1][sum - arr[i]];
                dp[i][sum] = take || notTake;
            }
        }
        return dp[n-1][s];
    }
}