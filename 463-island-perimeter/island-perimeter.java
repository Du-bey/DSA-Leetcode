class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] delr = {0, 1, 0, -1};
        int[] delc = {1, 0, -1, 0};
        int cnt = 0;

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                for(int ind=0;ind<4;ind++){
                    if(grid[i][j] == 1){
                        int nr = i + delr[ind];
                        int nc = j + delc[ind];
                        if(nr <0 || nc < 0 || nr == n || nc == m || grid[nr][nc] == 0){
                            cnt++;
                        }
                    }
                    
                }
            }
        }
        return cnt;
    }
}
