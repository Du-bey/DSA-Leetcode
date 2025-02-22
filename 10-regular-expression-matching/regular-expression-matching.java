class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        for(int[] r : dp) Arrays.fill(r, -1);
        return solve(0, 0, s, p, dp);
    }

    public boolean solve(int i, int j, String s, String p, int[][] dp){
        if(j == p.length()){
            return i == s.length();
        }

        if(dp[i][j] != -1) return dp[i][j] == 1 ? true : false;
        boolean match = (i < s.length()) && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i));
        if(j + 1 < p.length() && p.charAt(j+1) == '*'){
            boolean notTake = solve(i, j + 2, s, p, dp);
            boolean take = match && solve(i+1, j, s, p, dp);
            boolean ans = take || notTake;
            dp[i][j] = ans ? 1 : 0;
            return ans;
        }
        boolean ans1 = match && solve(i+1, j+1, s, p, dp);
        dp[i][j] = ans1 ? 1 : 0;
        return ans1;
    }
}