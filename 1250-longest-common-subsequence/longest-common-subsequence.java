class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];
        for(int i =1;i<=n;i++){
            int[] cur = new int[m+1];
            for(int j =1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    cur[j] = 1 + prev[j-1];
                }
                else{
                    cur[j] = Math.max(prev[j], cur[j-1]);
                }
            }
            prev = cur;
        }
        return prev[m];
    }

    public int f(int i, int j, String s, String t, int[][] dp){
        if(i == 0 || j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        
        return dp[i][j];
    }
}