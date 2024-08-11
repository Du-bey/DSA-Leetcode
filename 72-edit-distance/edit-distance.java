class Solution {
    public int minDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
        return f(n-1, m-1, s, t, dp);
    }

    public int f(int i, int j, String s, String t, int[][] dp){
        if(j < 0) return i+1;
        if(i < 0) return j+1;
        
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = f(i-1, j-1, s, t, dp);
        }
        else{
            int in = f(i, j-1, s, t, dp);
            int de = f(i-1, j, s, t, dp);
            int re = f(i-1, j-1, s, t, dp);
            dp[i][j] = 1 + Math.min(in, Math.min(de, re));
        }
        return dp[i][j];
    }
}