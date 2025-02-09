class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return f(0, 0, n, triangle, dp);
    }

    public int f(int i, int j, int n, List<List<Integer>> tri, int[][] dp){
        if(i > n-1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = tri.get(i).get(j) + Math.min(f(i+1, j, n, tri, dp), f(i+1, j+1, n, tri, dp));
    }
}
