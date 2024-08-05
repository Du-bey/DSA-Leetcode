class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int n = t1.length();
        int m = t2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return f(n-1, m-1, t1, t2, dp);
    }

    public int f(int i, int j, String t1, String t2, int[][] dp){
        if(i <0 || j <0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(t1.charAt(i) == t2.charAt(j)){
            dp[i][j] = 1 + f(i-1, j-1, t1, t2, dp);
        }
        else{
            dp[i][j] = Math.max(f(i-1, j, t1, t2, dp), f(i, j-1, t1, t2, dp));
        }
        return dp[i][j];
    }
}