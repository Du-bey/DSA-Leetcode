class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        if(sum < target || (sum - target) % 2 == 1) return 0;
        sum = (sum - target) / 2;
        return isSubsetSum(nums, sum);
    }

    public int isSubsetSum(int arr[], int target) {
        int n = arr.length;
        int[][] dp = new int[n][target + 1];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return f(n-1, arr, target, dp);
    }
    
    public int f(int i, int arr[], int t, int[][] dp){
        if(i == 0){
            if(t == 0 && arr[i] == 0) return 2;
            if(t == 0 || arr[0] == t) return 1;
            return 0;
        }
        if(t < 0) return 0;
        if(dp[i][t] != -1) return dp[i][t];
        int take = f(i-1, arr, t-arr[i], dp);
        dp[i][t] = f(i-1, arr, t, dp) + take;
        return dp[i][t];
    }
}