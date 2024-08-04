class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        if(n == 1) return t.get(0).get(0);
        int[][] dp = new int[n][n+1];
        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
        return f(0, 0, t, n, dp);
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