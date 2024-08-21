class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return f(0, n-1, s, dp);
    }
    
    public int f(int i, int j, String s, int[][] dp){
        if(i == j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;

        for(int k = i;k<j;k++){
            min = Math.min(min, f(i, k, s, dp) + f(k+1, j, s, dp));
        }
        if(s.charAt(i) == s.charAt(j)) min--;
        dp[i][j] = min;
        return dp[i][j];
    }
}
