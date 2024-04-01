class Solution {
    public int minDistance(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int[][] dp = new int[n1+1][n2+1];
        for(int i =0;i<=n1;i++){
            dp[i][0] = i+1;
        }
        for(int i =0;i<=n2;i++){
            dp[0][i] = i+1;
        }
        for(int i =1;i<=n1;i++){
            for(int j =1;j<=n2;j++){
                if(c1[i-1] == c2[j-1]){
                    dp[i][j] = dp[i-1][j-1] ;
                }
                else{
                    int a = 1 + dp[i][j-1];
                    int b = 1 + dp[i-1][j];
                    int c = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(a, Math.min(b,c));
                }
            }
        }
        return dp[n1][n2] - 1;
    }
}