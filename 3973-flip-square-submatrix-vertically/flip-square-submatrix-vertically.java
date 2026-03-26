class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        if(k == 0) return grid;

        int r0 = x;
        int r1 = x + k - 1;
        int c0 = y;
        int c1 = y + k - 1;

        while(r0 < r1){
            for(int j = c0 ; j<= c1;j++){
                int temp = grid[r0][j];
                grid[r0][j] = grid[r1][j];
                grid[r1][j] = temp;
            }
            r0++;
            r1--;
        }
        return grid;
    }
}