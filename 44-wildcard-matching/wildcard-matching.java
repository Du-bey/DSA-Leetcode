class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return f(n, m, s, p, dp);
    }

    public boolean f(int i, int j, String s, String p, int[][] dp){
        if(i == 0 && j == 0) return true;
        if(i > 0 && j == 0) return false;
        if(i == 0 && j > 0){
            while(j > 0){
                if(p.charAt(j-1) != '*') return false;
                j--;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 0 ? false : true;

        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
            dp[i][j] = f(i-1, j-1, s, p, dp) == true ? 1 : 0;
        }
        else if(p.charAt(j-1) == '*'){
            dp[i][j] = (f(i-1, j, s, p, dp) || f(i, j-1, s, p, dp)) == true ? 1 : 0;
        }
        else{
            dp[i][j] = 0;
        }
        return dp[i][j] == 0 ? false : true;
    }
}