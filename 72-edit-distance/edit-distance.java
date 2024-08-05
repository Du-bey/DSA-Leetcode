class Solution {
    public int minDistance(String w, String t) {
        int n = w.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];

        for(int i =0;i<=n;i++){
            for(int j =0;j<=m;j++){
                if(i == 0) dp[i][j] = j;
                else if(j == 0) dp[i][j] = i;
                else if(w.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int in = 1 + dp[i][j-1];
                    int del = 1 + dp[i-1][j];
                    int rep = 1 + dp[i-1][j-1];

                    dp[i][j] = Math.min(in, Math.min(del, rep));
                }
            }
        }
        return dp[n][m];
    }
}