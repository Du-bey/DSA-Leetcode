class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        return f(0, 0, n, triangle, dp);
    }

    public int f(int i, int ind, int n, List<List<Integer>> t, int[][] dp){
        if(i == n) return 0;
        if(dp[i][ind] != -1) return dp[i][ind];

        int ans = Integer.MAX_VALUE;
        int down = f(i+1, ind, n, t, dp);
        int right = f(i+1, ind + 1, n, t, dp);
        int min = Math.min(down, right);
        ans = Math.min(ans, min);
        return dp[i][ind] = ans + t.get(i).get(ind);
    }
}