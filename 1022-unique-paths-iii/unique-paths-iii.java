class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int x = 0;
        int y = 0;
        int emptyCells = 0;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0) emptyCells++;
                if(grid[i][j] == 1){
                    x = i;
                    y = j;
                }
                if (grid[i][j] == 2) {
                    emptyCells++;
                }
            }
        }
        return solve(x, y, grid, n, m, 0, emptyCells);
    }

    public int solve(int i, int j, int[][] grid, int n, int m, int cnt, int t){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == -1) return 0;
        if(grid[i][j] == 2){
            return cnt == t ? 1 : 0;
        }

        grid[i][j] = -1;
        int ans =   solve(i+1, j, grid, n, m, cnt+1, t) +
                    solve(i-1, j, grid, n, m, cnt+1, t) +
                    solve(i, j+1, grid, n, m, cnt+1, t) +
                    solve(i, j-1, grid, n, m, cnt+1, t);
        
        grid[i][j] = 0;
        return ans;
    }
}