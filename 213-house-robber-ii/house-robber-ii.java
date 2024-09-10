class Solution {
    int dp[][];
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        dp = new int[n+1][2];
        for(int i[] : dp)Arrays.fill(i,-1);

        int a = f(nums, 0, n-2);
        int b = f(nums, 1, n-1);
        return Math.max(a,b);
    }
    public int f(int[] nums, int st, int i){
        if(i < st) return 0;
        if(i == st) return nums[st];

        if(dp[i][st] != -1)return dp[i][st];

        int a = nums[i] + f(nums, st, i-2);
        int b = f(nums, st, i-1);
        dp[i][st] = Math.max(a, b);
        return dp[i][st];
    }
}