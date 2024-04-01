class Solution {
    public int numDistinct(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int[][] dp = new int[n1+1][n2+1];
        for(int i =0;i<=n1;i++){
            dp[i][0] = 1;
        }
        for(int i =1;i<=n1;i++){
            for(int j =1;j<=n2;j++){
                if(c1[i-1] == c2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n1][n2];
    }
}