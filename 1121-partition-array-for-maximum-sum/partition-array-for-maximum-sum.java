class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, k, arr, n, dp);
    }

    public int f(int i, int k, int[] arr, int n, int[] dp){
        if(i == n) return 0;

        if(dp[i] != -1) return dp[i];
        int max = -1;
        int ans = -1;
        int len = 0;
        for(int j = i;j<Math.min(n, i+k);j++){
            len++;
            max = Math.max(max, arr[j]);
            int cost = len * max + f(j+1, k, arr, n, dp);
            ans = Math.max(ans, cost);
        }

        dp[i] = ans;
        return dp[i];
    }
}