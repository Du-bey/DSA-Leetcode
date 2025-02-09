class Solution {
    int[][] d;
    public int minCut(String s) {
        int n = s.length();
        d = new int[n][n];
        for(int[] r : d){
            Arrays.fill(r, -1);
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, s, n, dp) - 1;
    }

    public int f(int i, String s, int n, int[] dp){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int min = Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(isPalindrome(i, s, j)){
                int cost = 1 + f(j+1, s, n, dp);
                min = Math.min(min, cost);
            }
        }
        return dp[i] = min;
    }

    public boolean isPalindrome(int i, String s, int j){
        if(d[i][j] != -1) return d[i][j] == 1 ? true : false;
        boolean ans = true;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                ans = false;
                break;
            }
            i++;
            j--;
        }
        d[i][j] = ans ? 1 : 0;
        return ans;
    }
}