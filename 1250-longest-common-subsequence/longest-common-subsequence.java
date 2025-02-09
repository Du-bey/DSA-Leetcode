class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return f(n, m, text1, text2, dp);
    }

    public int f(int i, int j, String s, String t, int[][] dp){
        if(i == 0 || j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        char c = s.charAt(i-1);
        char c2 = t.charAt(j-1);
        if(c == c2){
            dp[i][j] = 1 + f(i-1, j-1, s, t, dp);
        }
        else{
            dp[i][j] = Math.max(f(i-1, j, s, t, dp), f(i, j-1, s, t, dp));
        }
        return dp[i][j];
    }
}