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
        int val = tri.get(i).get(j);
        if(i == n-1) return val;

        if(dp[i][j] != -1) return dp[i][j];
        int d = f(i+1, j, n, tri, dp);
        int dr = f(i+1, j+1, n, tri, dp);
        int ans = Math.min(d, dr);
        return dp[i][j] = val + ans;
    }
}
