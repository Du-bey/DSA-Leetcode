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
        int x = nums[i];
        for(int ind = i + 1;(ind <=  i + x && ind < n); ind++){
            int cost = 1 + f(ind, nums, n, dp);
            ans = Math.min(ans, cost);
        }
        dp[i] = ans;
        return dp[i];
    }
}