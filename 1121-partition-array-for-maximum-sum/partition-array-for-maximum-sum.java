class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, n, arr, k, dp);
    }
    public int f(int i, int n, int[] arr, int k, int[] dp){
        if (i == n) return 0;

        if (dp[i] != -1) return dp[i];
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;

        for(int j =i;j< Math.min(i + k, n);j++){
            len++;
            maxi = Math.max(maxi, arr[j]);
            int ans = (len*maxi) + f(j+1, n, arr, k, dp);
            maxAns = Math.max(ans, maxAns);
        }
        dp[i] = maxAns;
        return dp[i];
    }
}