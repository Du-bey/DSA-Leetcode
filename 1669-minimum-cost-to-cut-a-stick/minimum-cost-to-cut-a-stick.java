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

        int[][] dp = new int[c + 2][c + 2];
        for(int i = c;i>=1;i--){
            for(int j =1;j<=c;j++){
                if(i > j) continue;
                int min = Integer.MAX_VALUE;
                for(int ind =i;ind <=j;ind++){
                    int cost = cut[j+1] - cut[i-1] + dp[i][ind-1] + dp[ind+1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c];
        
    }

}