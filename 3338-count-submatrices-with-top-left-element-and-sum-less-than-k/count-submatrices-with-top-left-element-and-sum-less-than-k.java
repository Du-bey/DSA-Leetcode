class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] pre = new int[n][m];
        int cnt = 0;

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                pre[i][j] = grid[i][j];
                if(i > 0) pre[i][j] += pre[i-1][j];
                if(j > 0) pre[i][j] += pre[i][j-1];
                if(i > 0 && j > 0) pre[i][j] -= pre[i-1][j-1];
                if(pre[i][j] <= k) cnt++;
            }
        }

        return cnt;
    }
}