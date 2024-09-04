class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 1){
                    return dfs(grid, i, j, n, m);
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, int i, int j, int n, int m){
        if(i <0 || j < 0 || i == n || j == m || grid[i][j] == 0){
            return 1;
        }
        if(grid[i][j] == -1) return 0;
        int cnt = 0;
        grid[i][j] = -1;

        cnt += dfs(grid, i-1, j, n, m);
        cnt += dfs(grid, i, j-1, n, m);
        cnt += dfs(grid, i+1, j, n, m);
        cnt += dfs(grid, i, j+1, n, m);
        return cnt;
    }
}