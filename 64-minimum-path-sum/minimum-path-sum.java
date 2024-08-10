class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] prev = new int[m];
        int[] cur = new int[m];
         for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i ==0 && j == 0) cur[j] = grid[0][0];
                else{
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i > 0){
                        up = prev[j];
                    }
                    if(j > 0){
                        left = cur[j-1];
                    }
                    cur[j] = grid[i][j] + Math.min(up, left);
                }
            }
            prev = cur;
        }
        return prev[m-1];
    }
}