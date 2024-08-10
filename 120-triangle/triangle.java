class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        if(n == 1) return t.get(0).get(0);
        int [][] dp = new int[n+1][n+1];
        for(int i =n-1;i>=0;i--){
            for(int j =0;j<=i;j++){
                int dr = dp[i+1][j+1];
                int d = dp[i+1][j];
                int cost = t.get(i).get(j) + Math.min(dr, d);
                dp[i][j] = cost;
            }
        }
        return dp[0][0];
    }
}