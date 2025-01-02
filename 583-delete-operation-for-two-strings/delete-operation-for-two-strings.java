class Solution {
    public int minDistance(String word1, String word2) {
        int lcs = lcs(word1, word2);
        int n = word1.length();
        int m = word2.length();
        return n+m - 2*lcs;
    }

    public int lcs(String t1, String t2) {
        int n = t1.length();
        int m = t2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(t1.charAt(i-1) == t2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}