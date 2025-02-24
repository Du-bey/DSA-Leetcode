class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int cnt = 0;
        for(int l =1;l <=n;l++){
            for(int i =0;i+l-1 < n;i++){
                int j = i+l-1;
                boolean same = s.charAt(i) == s.charAt(j);
                if(l == 1){
                    dp[i][i] = true;
                }
                else if(l == 2){
                    dp[i][j] = same;
                }
                else{
                    dp[i][j] = dp[i+1][j-1] && same;
                }

                if(dp[i][j]) cnt++;
            }
        }
        return cnt;
    }
}