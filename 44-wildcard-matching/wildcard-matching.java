class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] r : dp) Arrays.fill(r, -1);
        return f(n, m, s, p, dp);
    }

    public boolean f(int i, int j, String s, String p, int[][] dp){
        if(i == 0 && j == 0) return true;
        if(i > 0 && j == 0) return false;
        if(i == 0 && j > 0){
            for(int ind = 1;ind<=j;ind++){
                if(p.charAt(ind - 1) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != -1) return dp[i][j] == 1 ? true : false;
        boolean ans = false;
        if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
            ans = f(i-1, j-1, s, p, dp);
        }
        else if(p.charAt(j - 1) == '*'){
            ans = f(i, j-1, s, p, dp) || f(i-1, j, s, p, dp);
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}