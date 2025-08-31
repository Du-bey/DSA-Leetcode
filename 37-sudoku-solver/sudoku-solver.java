class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] grid){
        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){
                if(grid[i][j] == '.'){
                    for(char d = '1'; d<='9';d++){
                        if(isValid(grid, i, j, d)){
                            grid[i][j] = d;
                            if(solve(grid)) return true;
                            grid[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] grid, int r, int c, char d){
        for(int i = 0;i<9;i++){
            if(grid[i][c] == d) return false;
            if(grid[r][i] == d) return false;
        }

        int k = r / 3 * 3;
        int l = c / 3 * 3;
        for(int i = 0;i<3;i++){
            for(int j =0;j<3;j++){
                if(grid[k + i][l + j] == d) return false;
            }
        }
        return true;
    }
}