class Solution {
    int n;
    int m;
    int l;
    public boolean isInterleave(String s1, String s2, String s3) {
        n = s1.length();
        m = s2.length();
        l = s3.length();
        if (n + m != l) return false;
        int[][] dp = new int[n+1][m+1];
        for(int[] r : dp) Arrays.fill(r, -1);
        return f(0, 0, s1, s2, s3, dp);
    }

    public boolean f(int i, int j, String s1, String s2, String s3, int[][] dp){
        if(i == n && j == m) return true;
        if(dp[i][j] != -1) return dp[i][j] == 1 ? true : false;
        int k = i + j;
        char c = s3.charAt(k);
        boolean ans = false;
        if(i < n && s1.charAt(i) == c && f(i+1, j, s1, s2, s3, dp)){
            ans = true;
        }
        if(j < m && s2.charAt(j) == c && f(i, j+1, s1, s2, s3, dp)){
            ans = true;
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}