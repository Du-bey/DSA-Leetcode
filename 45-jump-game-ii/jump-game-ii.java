class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, nums, n, dp);
    }

    public int f(int i, int[] nums, int n, int[] dp){
        if(i >= n-1) return 0;
        if(dp[i] != -1) return dp[i];
        int ans = 100000000;
        for(int j=1;j<=nums[i];j++){
            ans = Math.min(1 + f(i+j, nums, n, dp), ans);
        }
        return dp[i] = ans;
    }
}