class Solution {
    public int minDistance(String w, String t) {
        int n = w.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return f(n-1, m-1, w, t, dp);
    }

    public int f(int i, int j, String w, String t, int[][] dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        
        if(dp[i][j] != -1) return dp[i][j];

        if(w.charAt(i) == t.charAt(j)){
            dp[i][j] = f(i-1, j-1, w, t, dp);
        }
        else{
            int in = 1 + f(i, j-1, w, t, dp);
            int del = 1 + f(i-1, j, w, t, dp);
            int rep = 1 + f(i-1, j-1, w, t, dp);

            dp[i][j] = Math.min(in, Math.min(del, rep));
        }
        return dp[i][j];
    }
}