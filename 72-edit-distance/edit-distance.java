class Solution {
    int[][] dp;
    public int minDistance(String s, String t) {
        int n = s.length();
        int m = t.length();

        dp = new int[n+1][m+1];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }

        return f(n, m, s, t);
    }

    public int f(int i, int j, String s, String t){
        if(j == 0) return i;
        if(i == 0) return j;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MAX_VALUE;
        if(s.charAt(i-1) == t.charAt(j-1)){
            ans = f(i-1, j-1, s, t);
        }
        else{
            int del = 1 + f(i-1, j, s, t);
            int ins = 1 + f(i, j-1, s, t);
            int rep = 1 + f(i-1, j-1, s, t);
            
            int st = Math.min(del, ins);
            st = Math.min(st, rep);
            ans = Math.min(ans, st);
        }
        return dp[i][j] = ans;
    }
}