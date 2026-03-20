class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] pre = new int[n][m];
        pre[0][0] = grid[0][0];
        for(int i = 1;i<n;i++){
            pre[i][0] = pre[i-1][0] + grid[i][0];
        }

        for(int j =1;j<m;j++){
            pre[0][j] = pre[0][j-1] + grid[0][j];
        }

        for(int i =1;i<n;i++){
            for(int j =1;j<m;j++){
                pre[i][j] += pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1] + grid[i][j];
            }
        }

        int cnt = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(pre[i][j] <= k) cnt++;
            }
        }
        return cnt;
    }
}