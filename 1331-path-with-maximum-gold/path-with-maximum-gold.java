class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = checkIfAllNonZero(grid, n, m);
        if(count != 0) return count;
        int ans = 0;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] !=0){
                    ans = Math.max(ans, dfs(i, j, new boolean[n][m], grid, n, m));
                }
            }
        }
        return ans;
    }

    public int checkIfAllNonZero(int[][] grid, int n, int m){
        int cnt = 0;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] !=0) cnt += grid[i][j];
                else return 0;
            }
        }
        return cnt;
    }

    public int dfs(int i, int j, boolean[][] vis, int[][] grid, int n, int m){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0 || vis[i][j]) return 0;
        vis[i][j] = true;
        int ans = 0;
        
        ans = Math.max(ans, dfs(i+1, j, vis, grid, n, m));
        ans = Math.max(ans, dfs(i-1, j, vis, grid, n, m));
        ans = Math.max(ans, dfs(i, j+1, vis, grid, n, m));
        ans = Math.max(ans, dfs(i, j-1, vis, grid, n, m));
        ans += grid[i][j];

        vis[i][j] = false;

        return ans;
    }
}