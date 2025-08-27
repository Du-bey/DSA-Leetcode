class Solution {
    int[][] dir = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    int m, n;
    public int lenOfVDiagonal(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    for(int d=0;d<4;d++){
                        ans = Math.max(ans, 1 + solve(i, j, d, true, 2, grid));
                    }
                }
            }
        }
        return ans;
    }

    public int solve(int i, int j, int d, boolean canTurn, int val, int[][] grid){
        int ni = i + dir[d][0];
        int nj = j + dir[d][1];

        if(ni < 0 || nj < 0 || ni == n || nj ==m || grid[ni][nj] != val) return 0;

        int ans = 1 + solve(ni, nj, d, canTurn, 2 - val, grid);
        if(canTurn){
            ans = Math.max(ans, 1 + solve(ni, nj, (d+1) % 4, false, 2 - val, grid));
        }
        return ans;
    }
}