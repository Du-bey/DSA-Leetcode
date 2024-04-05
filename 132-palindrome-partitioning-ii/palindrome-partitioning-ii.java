class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(s, n, dp, 0) - 1;
    }
    public int f(String s, int n, int[] dp, int i){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int minCost = Integer.MAX_VALUE;
        for(int j = i;j<n;j++){
            if(isPalindrome(i, j, s)){
                int cost = 1 + f(s, n, dp, j+1);
                minCost = Math.min(minCost, cost);
            }
        }
        dp[i] = minCost;
        return dp[i];
    }

    public boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}