class Solution {
    int[][] dp;

    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new int[n][n];
        int len = 0;
        int st = 0;
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        
        for(int i =0;i<n;i++){
            for(int j =i;j<n;j++){
                if(f(s, i, j, dp) == 1){
                    if((j - i + 1) > len){
                        len = j - i + 1;
                        st = i;
                    }
                }
            }
        }
        return s.substring(st, st + len);
    }

    public int f(String s, int i, int j, int[][] dp){
        if(i >= j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = f(s, i+1, j-1, dp);
        }
        return dp[i][j] = 0;
    }
}