class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        if(n == 1) return t.get(0).get(0);
        int[][] dp = new int[n+1][n+1];
        for(int i = n-1;i>=0;i--){
            for(int ind = i;ind >=0;ind--){
                int down = dp[i+1][ind];
                int right = dp[i+1][ind+1];
                int ans = Math.min(down, right) + t.get(i).get(ind);
                dp[i][ind] = ans;
            }
        }
        return dp[0][0];
    }
}