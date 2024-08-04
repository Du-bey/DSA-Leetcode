class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        if(n == 1) return t.get(0).get(0);
        int[][] dp = new int[n][n];
        for(int i =0;i<n;i++){
            dp[n-1][i] = t.get(n-1).get(i);
        }
        for(int i = n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int down = dp[i+1][j];
                int right = dp[i+1][j+1];
                dp[i][j] = t.get(i).get(j) + Math.min(down, right);
            }
        }
        return dp[0][0];
    }

    public int f(int i, int j, List<List<Integer>> t, int n, int[][] dp){
        if(i == n-1) return t.get(i).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int down = f(i+1, j, t, n, dp);
        int right = f(i+1, j+1, t, n, dp);
        dp[i][j] = t.get(i).get(j) + Math.min(down, right);
        return dp[i][j];
        
    }
}