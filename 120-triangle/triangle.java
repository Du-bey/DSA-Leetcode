class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;i++){
            dp[n-1][i] = t.get(n-1).get(i);
        }

        for(int i = n-2;i>=0;i--){
            for(int j = i; j>=0;j--){
                int d = dp[i+1][j];
                int dr = dp[i+1][j+1];
                dp[i][j] = t.get(i).get(j) + Math.min(d, dr);
            }
        }
        return dp[0][0];
    }
}