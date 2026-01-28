class Solution {
    int ans = 0;
    int[][] dp;
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for(int x : nums) sum += x;
        if(sum % 3 == 0) return sum;

        dp = new int[3][n];
        for(int[] r : dp) Arrays.fill(r, -1);
        f(0, 0, nums);
        return ans;
    }

    public void f(int t, int i, int[] nums){
        if(t % 3 == 0){
            ans = Math.max(ans, t);
        }

        if(i == nums.length) return;

        int mod = t % 3;
        if(dp[mod][i] >= t) return;
        dp[mod][i] = t;

        f(t+ nums[i], i + 1, nums);
        f(t, i+1, nums);
    }
}