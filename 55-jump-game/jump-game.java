class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, nums, n, dp);
    }

    public boolean f(int i, int[] nums, int n, int[] dp){
        if(i == n-1) return true;
        if(dp[i] != -1) return dp[i] == 1 ? true : false;
        boolean ans = false;
        for(int j=1;j<=nums[i];j++){
            if(f(i+j, nums, n, dp)){
                ans = true;
                break;
            }
        }
        dp[i] = ans ? 1 : 0;
        return ans;
    }
}