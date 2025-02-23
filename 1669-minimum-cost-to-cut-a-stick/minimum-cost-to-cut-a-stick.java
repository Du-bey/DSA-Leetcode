class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] cut = new int[c+2];
        for(int i =1;i<c+1;i++){
            cut[i] = cuts[i-1];
        }
        cut[0] = 0;
        cut[c+1] = n;
        Arrays.sort(cut);

        int[][] dp = new int[c + 1][c + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(1, c, cut, dp);
    }

    public int f(int i, int j, int[] cuts, int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int ind =i;ind <=j;ind++){
            int cost = cuts[j+1] - cuts[i-1] + f(i, ind-1, cuts, dp) + f(ind + 1, j, cuts, dp);
            min = Math.min(min, cost);
        }
        dp[i][j] = min;
        return dp[i][j];
    }
}