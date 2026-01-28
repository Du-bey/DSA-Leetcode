class Solution {
    int[][] dp;
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for(int x : nums) sum += x;
        if(sum % 3 == 0) return sum;

        dp = new int[3][n];
        for(int[] r : dp) Arrays.fill(r, -1);

        return f(0, 0, nums);
    }

    public int f(int t, int i, int[] nums){
        if(i == nums.length){
            if(t == 0) return 0;
            return Integer.MIN_VALUE;
        }

        if(dp[t][i] != -1) return dp[t][i];
        
        int take = nums[i] + f((t+ nums[i]) % 3, i + 1, nums);
        int notTake = f(t, i+1, nums);

        return dp[t][i] = Math.max(take, notTake);
    }
}