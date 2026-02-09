class Solution {
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    int n;
    int m;
    
    public int findMaxFish(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int ans = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] != 0 && !vis[i][j]){
                    ans = Math.max(ans, dfs(i, j, vis, grid));
                }
            }
        }

        return ans;
    }

    public int dfs(int r, int c, boolean[][] vis, int[][] grid){
        vis[r][c] = true;

        int ans = grid[r][c];

        for(int i =0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >=0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] != 0 && !vis[nr][nc]){
                ans += dfs(nr, nc, vis, grid);
            }
        }
        return ans;
    }
}