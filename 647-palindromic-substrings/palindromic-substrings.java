class Solution {
    int[][] dp;
    public int countSubstrings(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int[] r : dp) Arrays.fill(r, -1);
        int cnt = 0;
        for(int i =0;i<n;i++){
            for(int j =i;j<n;j++){
                if(isPalindrome(i, j, s)){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isPalindrome(int i, int j, String s) {
        if(dp[i][j] != -1) return dp[i][j] == 1 ? true : false;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)){
                dp[i][j] = 0;
                return false;
            }
            i++;
            j--;
        }
        dp[i][j] = 1;
        return true;
    }
}