class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n = t.size();
        if(n == 1) return t.get(0).get(0);
        int[] prev = new int[n];
        for(int i =0;i<n;i++){
            prev[i] = t.get(n-1).get(i);
        }
        for(int i = n-2;i>=0;i--){
            int[] cur = new int[n];
            for(int j=0;j<=i;j++){
                int down = prev[j];
                int right = prev[j+1];
                cur[j] = t.get(i).get(j) + Math.min(down, right);
            }
            prev = cur;
        }
        return prev[0];
    }

    public int f(int i, int j, List<List<Integer>> t, int n, int[][] dp){
        if(i == n-1) return t.get(i).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int down = f(i+1, j, t, n, dp);
        int right = f(i+1, j+1, t, n, dp);
        dp[i][j] = t.get(i).get(j) + Math.min(down, right);
        return dp[i][j];
        
    }
}