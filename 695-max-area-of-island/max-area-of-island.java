class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(n == 1 && m == 1) return grid[0][0];
        boolean [][] vis = new boolean[n][m];
        int cnt = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    cnt = Math.max(cnt, dfs(i, j, vis, grid, n, m));
                }
            }
        }
        return cnt;
    }

    public int dfs(int i, int j, boolean [][] vis, int[][] grid, int n, int m){
        int cnt = 0;
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0 || vis[i][j]){
            return 0;
        }
        cnt++;
        vis[i][j] = true;
        cnt += dfs(i+1, j, vis, grid, n, m);
        cnt += dfs(i-1, j, vis, grid, n, m);
        cnt += dfs(i, j+1, vis, grid, n, m);
        cnt += dfs(i, j-1, vis, grid, n, m);
        return cnt;
    }

}